package com.example.crud_spring2

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired

@Service
class ProductService @Autowired constructor(private val productRepository: ProductRepository) {

    fun createProduct(product: Product): Product {
        return productRepository.save(product)
    }

    fun getAllProducts(): List<Product> {
        return productRepository.findAll()
    }

    fun getProductById(id: Long): Product? {
        return productRepository.findById(id).orElse(null)
    }

    fun updateProduct(id: Long, updatedProduct: Product): Product? {
        return if (productRepository.existsById(id)) {
            val product = updatedProduct.copy(id = id)
            productRepository.save(product)
        } else {
            null
        }
    }

    fun deleteProduct(id: Long) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id)
        }
    }
}

