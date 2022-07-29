package com.example.inteli.domain

import com.example.inteli.data.model.Drink
import com.example.inteli.vo.Resource

interface Repo {
    suspend fun getTragosList(nameTrago: String): Resource<List<Drink>>
}