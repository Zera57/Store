package com.zera.store.account.controller

import com.zera.store.account.service.AccountAdminService
import com.zera.store.account.storage.model.Account
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/account/admin")
class AccountAdminController(val accountAdminService: AccountAdminService) {
    @GetMapping
    fun getAll() : List<Account> {
        return accountAdminService.getAll()
    }

    @PostMapping("/save")
    fun save(@RequestBody account: Account) {
        accountAdminService.saveAccount(account)
    }

    @DeleteMapping("/delete")
    fun delete(@RequestParam id: UUID) {
        accountAdminService.deleteAccount(id)
    }
}
