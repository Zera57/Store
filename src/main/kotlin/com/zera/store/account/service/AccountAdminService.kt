package com.zera.store.account.service

import com.zera.store.account.storage.model.Account
import java.util.*

interface AccountAdminService {
    fun getAll() : List<Account>
    fun saveAccount(account: Account)
    fun deleteAccount(id: UUID)
}
