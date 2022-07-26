package com.example.inteli.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.inteli.domain.Repo
import com.example.inteli.vo.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel(repo: Repo):ViewModel() {

    val fetchTragosList = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repo.getTragosList())
        }catch (e : Exception){
            emit(Resource.Failure(e))
        }

    }

}