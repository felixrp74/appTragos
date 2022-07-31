package com.example.inteli.domain

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.inteli.data.model.DrinkEntity

@Dao
interface TragosDao {
    @Query("SELECT * FROM tragoEntity")
    suspend fun getAllFavoriteDrinks():List<DrinkEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrago(drink:DrinkEntity)


}