package com.nyinyihtunlwin.data.mapper

import com.nyinyihtunlwin.data.model.response.CocktailResponse
import com.nyinyihtunlwin.domain.model.cocktail.Cocktail

class CocktailMapper {

    fun mapCocktailsList(cocktailsList: List<CocktailResponse>):
            List<Cocktail> {
        val cocktails = arrayListOf<Cocktail>()
        cocktailsList.forEach {
            val cocktail = Cocktail(
                it.idDrink,
                it.strDrink,
                it.strDrinkThumb
            )
            cocktails.add(cocktail)
        }
        return cocktails
    }
}