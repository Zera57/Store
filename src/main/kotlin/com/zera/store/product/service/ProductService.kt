package com.zera.store.product.service

import com.zera.store.product.storage.model.Product
import org.springframework.stereotype.Service
import java.util.*

@Service
interface ProductService {
    fun get(id : UUID) : Product
    fun get(ids: List<UUID>) : List<Product>
    fun get() : List<Product>
    fun add(product : Product): UUID
    fun delete(id : UUID)
}
