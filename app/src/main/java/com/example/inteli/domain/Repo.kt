package com.example.inteli.domain

import com.example.inteli.data.model.Drink
import com.example.inteli.data.model.DrinkEntity
import com.example.inteli.vo.Resource

interface Repo {
    suspend fun getTragosList(nameTrago: String): Resource<List<Drink>>
    suspend fun getTragosFavoritos(): Resource<List<DrinkEntity>>
    suspend fun insertTrago(trago: DrinkEntity)
}