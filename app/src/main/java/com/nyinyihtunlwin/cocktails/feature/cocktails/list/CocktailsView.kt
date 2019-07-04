package com.nyinyihtunlwin.cocktails.feature.cocktails.list

import com.hannesdorfmann.mosby3.mvp.MvpView
import com.nyinyihtunlwin.domain.viewstate.CocktailsListViewState
import io.reactivex.Observable

interface CocktailsView : MvpView {

    fun render(viewState: CocktailsListViewState)

    fun cocktailsIntent(): Observable<String>

}