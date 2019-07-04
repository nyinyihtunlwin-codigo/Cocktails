package com.nyinyihtunlwin.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nyinyihtunlwin.data.database.entity.CocktailEntity
import io.reactivex.Single

@Dao
interface CocktailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCocktails(entities: List<CocktailEntity>): List<Long>

    @Query("SELECT * FROM cocktails")
    fun getCocktails(): Single<List<CocktailEntity>>

    @Query("SELECT * FROM cocktails WHERE isAlcoholic = :alcoholic")
    fun getAlcoholicCocktails(alcoholic: Boolean = true): Single<List<CocktailEntity>>

    @Query("SELECT * FROM cocktails WHERE isAlcoholic = :alcoholic")
    fun getNonAlcoholicCocktails(alcoholic: Boolean = false): Single<List<CocktailEntity>>

}