package com.nyinyihtunlwin.domain.viewstate

import com.nyinyihtunlwin.domain.model.cocktail.Cocktail

sealed class CocktailDetailsViewState {

    class Error(val t: Throwable) : CocktailDetailsViewState()

    class CocktailDetails(val cocktail: Cocktail) : CocktailDetailsViewState()

    object Progress : CocktailDetailsViewState()

}