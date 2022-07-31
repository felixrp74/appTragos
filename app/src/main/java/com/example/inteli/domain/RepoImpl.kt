package com.example.inteli.domain

import com.example.inteli.data.DataSource
import com.example.inteli.data.model.Drink
import com.example.inteli.data.model.DrinkEntity
import com.example.inteli.vo.Resource

class RepoImpl(private val dataSource: DataSource):Repo {
    override suspend fun getTragosList(nameTrago:String): Resource<List<Drink>> {
        return dataSource.getTragoByName(nameTrago)
    }

    override suspend fun getTragosFavoritos(): Resource<List<DrinkEntity>> {
        return dataSource.getTragosFavoritos()
    }

    override suspend fun insertTragos(trago: DrinkEntity) {
        dataSource.guardarTrago(trago)
    }

}