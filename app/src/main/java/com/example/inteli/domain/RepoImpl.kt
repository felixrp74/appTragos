package com.example.inteli.domain

import com.example.inteli.data.DataSource
import com.example.inteli.data.model.Drink
import com.example.inteli.vo.Resource

class RepoImpl(private val dataSource: DataSource):Repo {
    override fun getTragosList(): Resource<List<Drink>> {
        return dataSource.generateTragosList
    }
}