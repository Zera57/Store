package com.zera.store.account.storage

import com.zera.store.account.storage.model.Account
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AccountRepository : JpaRepositoryImplementation<Account, UUID> {
    fun findByUserName(userName: String): Optional<Account>
}
