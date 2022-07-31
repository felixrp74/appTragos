package com.example.inteli

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.inteli.data.model.DrinkEntity
import com.example.inteli.domain.TragosDao

<<<<<<< HEAD
//es el punto de partida de la instancia de ROOM

@Database(entities = [DrinkEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun TragoDao(): TragosDao
=======
@Database(entities = [DrinkEntity::class], version = 1)

abstract class AppDatabase : RoomDatabase() {

    abstract fun tragosDao(): TragosDao
>>>>>>> bab6224829fce076904cbcb3e82fbca94a754642

    companion object {
        private var INSTANCE: AppDatabase? = null

<<<<<<< HEAD
        fun getDatabase(context: Context): AppDatabase {
            INSTANCE = INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "tabla_tragos"
            ).build()
            return INSTANCE!!

        }

        fun destroyInstance(){
            INSTANCE = null
        }
    }


=======
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
>>>>>>> bab6224829fce076904cbcb3e82fbca94a754642
}