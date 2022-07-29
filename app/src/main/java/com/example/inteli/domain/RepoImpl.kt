package com.example.inteli.domain

import com.example.inteli.data.DataSource
import com.example.inteli.data.model.Drink
import com.example.inteli.vo.Resource

class RepoImpl(private val dataSource: DataSource):Repo {
    override suspend fun getTragosList(tragoName:String): Resource<List<Drink>> {
        return dataSource.getTragoByName(tragoName)
    }
}