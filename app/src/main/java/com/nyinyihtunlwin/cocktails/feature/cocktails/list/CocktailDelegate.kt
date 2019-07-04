package com.nyinyihtunlwin.cocktails.feature.cocktails.list

import com.nyinyihtunlwin.domain.model.cocktail.Cocktail

interface CocktailDelegate {
    fun onTapCocktail(cocktail : Cocktail)
}