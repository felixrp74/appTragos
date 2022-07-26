package com.example.inteli.data

import com.example.inteli.data.model.Drink
import com.example.inteli.vo.Resource

class DataSource {

    private val generateTragosList = listOf(
        Drink("https://www.recetasdeescandalo.com/como-preparar-el-coctel-margarita-receta-e-ingredientes/","margarita","con azucar vodka y nueces"),
        Drink("https://franchoxbar.wordpress.com/2018/07/16/fernandito-o-fernet-con-coca/","fernet","con azucar vodka y nueces")
    )

    fun getDrinksList():Resource<List<Drink>>{
        return Resource.Success(generateTragosList)
    }
}