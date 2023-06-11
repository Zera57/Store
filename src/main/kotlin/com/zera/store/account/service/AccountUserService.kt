package com.zera.store.account.service

import com.zera.store.account.storage.model.Account
import org.springframework.security.core.userdetails.UserDetailsService

interface AccountUserService : UserDetailsService {
    fun register(account: Account)
}
