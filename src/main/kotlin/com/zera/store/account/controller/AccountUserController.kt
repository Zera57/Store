package com.zera.store.account.controller

import com.zera.store.account.service.AccountUserService
import com.zera.store.account.storage.model.Account
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/account")
class AccountUserController(val accountUserService: AccountUserService) {
    @PostMapping("/register")
    fun register(@RequestBody account: Account) {
        accountUserService.register(account)
    }
}
