package com.nyinyihtunlwin.domain.viewstate

import com.nyinyihtunlwin.domain.model.cocktail.Cocktail

sealed class CocktailsListViewState {

    class Error(val t: Throwable) : CocktailsListViewState()

    class Cocktails(val cocktails: List<Cocktail>) : CocktailsListViewState()

    object Progress : CocktailsListViewState()

}