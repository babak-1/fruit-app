package com.babak.fruitapplication.api

import com.babak.fruitapplication.model.ProductResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProductService {
    @GET("api/v1/products")
    suspend fun getProductsApi():Response<List<ProductResponse>>
}