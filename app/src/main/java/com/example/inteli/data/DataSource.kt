package com.example.inteli.data

import com.example.inteli.data.model.Drink
import com.example.inteli.vo.Resource

class DataSource {

    val generateTragosList = Resource.Success(listOf(
        Drink("https://cdn5.recetasdeescandalo.com/wp-content/uploads/2018/09/Coctel-margarita-como-prepararlo.-Receta-e-ingredientes.jpg","margarita","con azucar vodka y nueces"),
        Drink("https://http2.mlstatic.com/D_NQ_NP_667140-MPE31254049113_062019-O.jpg","fernet","con azucar vodka y nueces")
    ))
}