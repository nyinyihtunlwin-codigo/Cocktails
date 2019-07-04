package com.nyinyihtunlwin.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nyinyihtunlwin.data.database.dao.CocktailDao
import com.nyinyihtunlwin.data.database.entity.CocktailEntity


@Database(entities = [CocktailEntity::class], version = 1)
abstract class RxDatabase : RoomDatabase() {

    abstract fun cocktailDao(): CocktailDao

}