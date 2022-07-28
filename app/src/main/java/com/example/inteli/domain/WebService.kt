package com.example.inteli.domain

import com.example.inteli.data.model.Drink
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("search.php?s=")
    suspend fun getTragosByName(@Query("tragoName") tragoName:String):List<Drink>{

    }


}