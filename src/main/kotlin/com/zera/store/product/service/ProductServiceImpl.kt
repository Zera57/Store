package com.zera.store.product.service

import com.zera.store.product.storage.model.Product
import com.zera.store.product.storage.repository.ProductRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductServiceImpl (val productRepository: ProductRepository) : ProductService {
    override fun get(id: UUID): Product {
        return productRepository.findById(id).orElseThrow { EntityNotFoundException() }
    }

    override fun get(): List<Product> {
        return productRepository.findAll()
    }

    override fun add(product: Product) : UUID {
        return productRepository.save(product).id!!
    }

    override fun delete(id: UUID) {
        productRepository.deleteById(id)
    }
}
