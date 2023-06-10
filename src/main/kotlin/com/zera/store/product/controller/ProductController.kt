package com.zera.store.product.controller

import com.zera.store.product.service.ProductService
import com.zera.store.product.storage.model.Product
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/product")
class ProductController(val productService: ProductService) {
    @GetMapping
    fun get(@RequestParam("id") id : UUID) : Product {
        return productService.get(id)
    }

    @GetMapping("/all")
    fun get() : List<Product> {
        return productService.get()
    }

    @PostMapping("/add")
    fun add(@RequestBody product: Product) : UUID {
        return productService.add(product)
    }

    @DeleteMapping("/delete")
    fun delete(@RequestParam("id") id : UUID) {
        productService.delete(id)
    }
}
