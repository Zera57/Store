package com.zera.store.purchase.mapper

import com.zera.store.account.storage.model.Account
import com.zera.store.product.storage.model.Product
import com.zera.store.purchase.model.CreatePurchaseRq
import com.zera.store.purchase.model.PurchaseDto
import com.zera.store.purchase.storage.model.Purchase
import java.time.OffsetDateTime
import java.util.*

fun CreatePurchaseRq.toPurchases(products: List<Product>, account: Account) : List<Purchase> {
    val id = UUID.randomUUID()
    return purchases.map { it.toPurchase(id, products, account) }
}

fun PurchaseDto.toPurchase(id: UUID, products: List<Product>, account: Account) : Purchase {
    var purchase = Purchase()
    purchase.id = id
    purchase.account = account
    purchase.amount = amount
    purchase.purchaseDate = OffsetDateTime.now()
    purchase.product = products.find { it.id == productId }
    return purchase
}


