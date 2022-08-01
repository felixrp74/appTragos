package com.example.inteli.data

import com.example.inteli.AppDatabase
import com.example.inteli.data.model.Drink
import com.example.inteli.data.model.DrinkEntity
import com.example.inteli.vo.Resource
import com.example.inteli.vo.RetrofitClient

class DataSource(private val appDatabase: AppDatabase) {

    suspend fun getTragoByName(tragoName:String):Resource<List<Drink>>{
        return Resource.Success(RetrofitClient.webService.getTragosByName(tragoName).drinkList)
    }

    suspend fun guardarTrago(drinkEntity: DrinkEntity){
        appDatabase.TragoDao().insertTrago(drinkEntity)
    }

    suspend fun getTragosFavoritos():Resource<List<DrinkEntity>>{
        return Resource.Success(appDatabase.TragoDao().getAllFavoriteDrinks())
    }
}