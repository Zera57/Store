package com.zera.store.account.service

import com.zera.store.account.storage.AccountRepository
import com.zera.store.account.storage.model.Account
import org.springframework.stereotype.Service
import java.util.*

@Service
class AccountAdminServiceImpl(val accountRepository: AccountRepository) : AccountAdminService {
    override fun getAll(): List<Account> {
        return accountRepository.findAll()
    }

    override fun saveAccount(account: Account) {
        accountRepository.save(account)
    }

    override fun deleteAccount(id: UUID) {
        accountRepository.deleteById(id)
    }
}
