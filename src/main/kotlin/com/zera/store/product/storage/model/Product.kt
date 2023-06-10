package com.zera.store.product.storage.model

import jakarta.persistence.*
import java.util.*

@Entity
open class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: UUID? = null
    @Column(nullable = false)
    open var name: String? = null
    @Column
    open var description: String? = null
    @Column(nullable = false)
    open var cost: Long? = null
    @Column(nullable = false)
    open var count: Long? = null
}
