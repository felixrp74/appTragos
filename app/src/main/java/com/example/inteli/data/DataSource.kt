package com.example.inteli.data

import com.example.inteli.data.model.Drink
import com.example.inteli.vo.Resource
import com.example.inteli.vo.RetrofitClient

class DataSource {

    suspend fun getTragoByName(tragoName:String):Resource<List<Drink>>{
        return Resource.Success(RetrofitClient.webService.getTragosByName(tragoName).drinkList)
    }
}