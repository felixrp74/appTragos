package com.example.inteli

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.inteli.data.model.DrinkEntity
import com.example.inteli.domain.TragosDao

@Database(entities = [DrinkEntity::class], version = 1)

abstract class AppDatabase : RoomDatabase() {

    abstract fun tragosDao(): TragosDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context:Context): AppDatabase {
            INSTANCE ?:   Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, "tabla_tragos"
            ).build()

            return INSTANCE!!
        }
/*
        fun destroyedInstance(){
            INSTANCE = null
        }*/
    }
}