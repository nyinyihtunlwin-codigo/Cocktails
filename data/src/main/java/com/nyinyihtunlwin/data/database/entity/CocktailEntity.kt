package com.nyinyihtunlwin.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cocktails")
data class CocktailEntity(
    @PrimaryKey(autoGenerate = false) var idDrink: String,
    @ColumnInfo(name = "strDrink") var strDrink: String,
    @ColumnInfo(name = "strDrinkThumb") var strDrinkThumb: String,
    @ColumnInfo(name = "isAlcoholic") var isAlcoholic: Boolean
)