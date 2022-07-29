package com.example.inteli.domain

import com.example.inteli.data.model.DrinkList
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("search.php")
    suspend fun getTragosByName(@Query(value = "s") tragoName:String): DrinkList
}