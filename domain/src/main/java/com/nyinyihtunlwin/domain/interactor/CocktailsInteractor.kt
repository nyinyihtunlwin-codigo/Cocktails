package com.nyinyihtunlwin.domain.interactor

import com.nyinyihtunlwin.domain.executor.BackgroundThread
import com.nyinyihtunlwin.domain.executor.PostExecutionThread
import com.nyinyihtunlwin.domain.repository.CocktailsRepository
import com.nyinyihtunlwin.domain.viewstate.CocktailDetailsViewState
import com.nyinyihtunlwin.domain.viewstate.CocktailsListViewState
import io.reactivex.Observable

class CocktailsInteractor(
    private val cocktailsRepository: CocktailsRepository,
    private val mainThread: PostExecutionThread,
    private val backgroundThread: BackgroundThread
) {
    fun executeCocktails(type:String): Observable<CocktailsListViewState> {
        return cocktailsRepository.getCocktails(type)
            .map { CocktailsListViewState.Cocktails(it) }
            .cast(CocktailsListViewState::class.java)
            .onErrorReturn { CocktailsListViewState.Error(it) }
            .startWith(CocktailsListViewState.Progress)
            .subscribeOn(backgroundThread.getScheduler())
            .observeOn(mainThread.getScheduler())
    }

    fun executeCocktailDetails(id: String): Observable<CocktailDetailsViewState> {
        return cocktailsRepository.getCocktailDetails(id)
            .map { CocktailDetailsViewState.CocktailDetails(it) }
            .cast(CocktailDetailsViewState::class.java)
            .onErrorReturn { CocktailDetailsViewState.Error(it) }
            .startWith(CocktailDetailsViewState.Progress)
            .subscribeOn(backgroundThread.getScheduler())
            .observeOn(mainThread.getScheduler())
    }
}