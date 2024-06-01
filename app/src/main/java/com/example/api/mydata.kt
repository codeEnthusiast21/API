package com.example.api

data class mydata(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)