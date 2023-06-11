package com.zera.store.account.service

import com.zera.store.account.storage.AccountRepository
import com.zera.store.account.storage.model.Account
import com.zera.store.account.storage.model.AccountRole
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AccountUserServiceImpl(val accountRepository: AccountRepository, val passwordEncoder: PasswordEncoder) : AccountUserService {
    override fun register(account: Account) {
        val findByUserName = accountRepository.findByUserName(account.username)
        if (findByUserName.isPresent) {
            throw RuntimeException("Account with ${account.username} UserName already exists")
        }

        account.accountRole = AccountRole.CUSTOMER
        account.password = passwordEncoder.encode(account.password)
        accountRepository.save(account)
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        return accountRepository
            .findByUserName(
                username ?: throw RuntimeException("Empty username")
            ).orElseThrow()
    }
}
