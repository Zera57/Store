package com.zera.store.purchase.service

import com.zera.store.account.service.AccountUserService
import com.zera.store.account.storage.model.Account
import com.zera.store.product.service.ProductService
import com.zera.store.purchase.mapper.toPurchases
import com.zera.store.purchase.model.CreatePurchaseRq
import com.zera.store.purchase.storage.model.Purchase
import com.zera.store.purchase.storage.repository.PurchaseRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.*

@Service
class PurchaseServiceImpl (val accountUserService: AccountUserService, val productService: ProductService, val purchaseRepository: PurchaseRepository) : PurchaseService {
    override fun get(userName: String): List<Purchase> {
        return purchaseRepository.findAllByAccountUsername(userName)
    }

    @Transactional
    override fun save(createPurchaseRq: CreatePurchaseRq, account: Account): List<UUID> {
        // Проверка продуктов в заказе
        val expectedIds = createPurchaseRq.purchases.map { it.productId }
        val products = productService.get(expectedIds)

        if (products.size != expectedIds.size) {
            throw RuntimeException("Присутствуют не существующие продукты")
        }

        val purchases = createPurchaseRq.toPurchases(products, account)

        for (purchase in purchases) {
            val count = purchase.product!!.count
            val amount = purchase.amount!!

            if (count!! < amount) {
                throw RuntimeException("Продукта ${purchase.product} осталось $count")
            }
            purchase.product!!.count = count - amount
        }
        return purchaseRepository.saveAll(purchases).map { it.id!! }
    }

    override fun delete(id: UUID) {
        purchaseRepository.deleteAllById(id)
    }
}
