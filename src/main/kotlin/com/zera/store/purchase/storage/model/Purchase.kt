package com.zera.store.purchase.storage.model

import com.zera.store.account.storage.model.Account
import com.zera.store.product.storage.model.Product
import jakarta.persistence.*
import java.time.OffsetDateTime
import java.util.*

@Entity
@IdClass(PurchaseId::class)
open class Purchase {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: UUID? = null
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    open var account: Account? = null
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    open var product: Product? = null
    @Column(nullable = false)
    open var amount: Long? = null
    @Column(nullable = false)
    open var purchaseDate: OffsetDateTime? = null
}
