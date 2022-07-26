package com.example.inteli.domain

import com.example.inteli.data.model.Drink
import com.example.inteli.vo.Resource

interface Repo {
    fun getTragosList():Resource<List<Drink>>
}