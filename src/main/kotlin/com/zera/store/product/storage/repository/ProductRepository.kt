package com.zera.store.product.storage.repository

import com.zera.store.product.storage.model.Product
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProductRepository : JpaRepositoryImplementation<Product, UUID> {
}
