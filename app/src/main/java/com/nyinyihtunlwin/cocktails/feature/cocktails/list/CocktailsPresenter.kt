package com.nyinyihtunlwin.cocktails.feature.cocktails.list

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import com.nyinyihtunlwin.domain.interactor.CocktailsInteractor
import com.nyinyihtunlwin.domain.viewstate.CocktailsListViewState
import io.reactivex.Observable

class CocktailsPresenter(private val cocktailsInteractor: CocktailsInteractor) :
    MviBasePresenter<CocktailsView, CocktailsListViewState>() {
    override fun bindIntents() {
        val cocktailsIntent: Observable<CocktailsListViewState> = intent(CocktailsView::cocktailsIntent)
            .flatMap { cocktailsInteractor.executeCocktails(it) }
        subscribeViewState(cocktailsIntent, CocktailsView::render)
    }
}