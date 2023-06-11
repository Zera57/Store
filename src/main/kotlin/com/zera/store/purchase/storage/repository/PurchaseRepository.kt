package com.zera.store.purchase.storage.repository

import com.zera.store.purchase.storage.model.Purchase
import com.zera.store.purchase.storage.model.PurchaseId
import org.springframework.data.jpa.repository.Query
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PurchaseRepository : JpaRepositoryImplementation<Purchase, PurchaseId> {
    @Query(
        value = "select p.* from purchase p " +
                "left join account a on " +
                "a.id = p.account_id and " +
                "a.user_name = :userName", nativeQuery = true
    )
    fun findAllByAccountUsername(userName: String) : List<Purchase>

    fun deleteAllById(id: UUID)
}
