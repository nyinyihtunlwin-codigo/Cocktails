package com.nyinyihtunlwin.data.database

import android.content.Context
import androidx.room.Room
import com.nyinyihtunlwin.data.database.dao.CocktailDao

class RoomDbHelper constructor(private val context: Context) {

    private val cocktailDao: CocktailDao


    init {
        val rxDatabase: RxDatabase = Room.databaseBuilder(
            context, RxDatabase::class.java,
            "cocktails"
        )
            .fallbackToDestructiveMigration()
            .build()
        cocktailDao = rxDatabase.cocktailDao()

    }

    fun getCocktailDao(): CocktailDao = cocktailDao

}