package com.zera.store.product.storage.repository

import com.zera.store.product.storage.model.Product
import org.springframework.data.jpa.repository.Query
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProductRepository : JpaRepositoryImplementation<Product, UUID> {
    @Query( "select p from Product p where p.id in :ids" )
    fun findAllByIds(@Param("ids")ids: List<UUID>) : List<Product>
}
