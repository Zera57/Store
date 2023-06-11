package com.zera.store.purchase.controller

import com.zera.store.account.storage.model.Account
import com.zera.store.purchase.model.CreatePurchaseRq
import com.zera.store.purchase.service.PurchaseService
import com.zera.store.purchase.storage.model.Purchase
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/purchase")
class PurchaseController(val purchaseService: PurchaseService) {
    @GetMapping
    fun get(authentication: Authentication) : List<Purchase> {
        return purchaseService.get(authentication.name)
    }

    @PostMapping("/save")
    fun save(@RequestBody purchaseRq: CreatePurchaseRq, authentication: Authentication) : List<UUID> {
        return purchaseService.save(purchaseRq, authentication.principal as Account)
    }

    @DeleteMapping("/delete")
    fun delete(@RequestParam("id") id : UUID) {
        purchaseService.delete(id)
    }
}
