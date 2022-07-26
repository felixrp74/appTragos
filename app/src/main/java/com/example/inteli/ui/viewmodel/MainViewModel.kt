package com.example.inteli.ui.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.inteli.data.model.DrinkEntity
import com.example.inteli.domain.Repo
import com.example.inteli.vo.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(val repo: Repo) : ViewModel() {

    private var tragosData = MutableLiveData<String>()

    fun setTrago(nameTrago: String) {
        tragosData.value = nameTrago
    }

    init {
        setTrago("margarita")
    }

    val fetchTragosList = tragosData.distinctUntilChanged().switchMap { nameTrago ->
        liveData(Dispatchers.IO) {
            emit(Resource.Loading())
            try {
                Log.d("MAINVIEWMODEL","$nameTrago")
                emit(repo.getTragosList(nameTrago))
            } catch (e: Exception) {
                emit(Resource.Failure(e))
            }
        }
    }

    val fetchTragosFavoritoList = tragosData.distinctUntilChanged().switchMap { nameTrago ->
        liveData(Dispatchers.IO) {
            emit(Resource.Loading())
            try {
                Log.d("MAINVIEWMODEL","$nameTrago")
                emit(repo.getTragosFavoritos())
            } catch (e: Exception) {
                emit(Resource.Failure(e))
            }

        }
    }

    fun guardarTrago(trago:DrinkEntity){
        viewModelScope.launch {
            repo.insertTragos(trago)
        }
    }





}