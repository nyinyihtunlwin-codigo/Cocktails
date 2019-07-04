package com.nyinyihtunlwin.domain.repository

import com.nyinyihtunlwin.domain.model.cocktail.Cocktail
import io.reactivex.Observable

interface CocktailsRepository {

    fun getCocktails(type : String): Observable<List<Cocktail>>

    fun getCocktailDetails(id: String): Observable<Cocktail>

}