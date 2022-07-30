package com.example.inteli.domain

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.inteli.data.model.DrinkEntity

@Dao
interface TragosDao {

    @Query("SELECT * FROM tragosEntity")
    suspend fun getAllFavoriteDrinks():List<DrinkEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(trago:DrinkEntity)

}