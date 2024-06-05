package com.babak.fruitapplication

import com.babak.fruitapplication.api.ProductService
import com.babak.fruitapplication.model.ProductResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class ProductsRepository @Inject constructor(private val productService: ProductService) {
    suspend fun getAllProducts():Response<List<ProductResponse>>{
        return productService.getProductsApi()
    }
}