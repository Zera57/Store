package com.zera.store.purchase.service

import com.zera.store.account.storage.model.Account
import com.zera.store.purchase.model.CreatePurchaseRq
import com.zera.store.purchase.storage.model.Purchase
import org.springframework.stereotype.Service
import java.util.*

@Service
interface PurchaseService {
    fun get(userName : String) : List<Purchase>
    fun save(createPurchaseRq: CreatePurchaseRq, account: Account): List<UUID>
    fun delete(id : UUID)
}
