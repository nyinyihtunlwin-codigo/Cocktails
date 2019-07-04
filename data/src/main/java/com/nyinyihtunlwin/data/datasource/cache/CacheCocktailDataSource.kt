package com.nyinyihtunlwin.data.datasource.cache

import com.nyinyihtunlwin.data.database.RoomDbHelper
import com.nyinyihtunlwin.data.database.entity.CocktailEntity
import io.reactivex.Observable

class CacheCocktailDataSource(private val dbHelper: RoomDbHelper) {

    fun saveCocktails(entities: List<CocktailEntity>): Observable<List<CocktailEntity>> {
        dbHelper.getCocktailDao().insertCocktails(entities)
        return dbHelper.getCocktailDao().getCocktails().toObservable()
    }

}