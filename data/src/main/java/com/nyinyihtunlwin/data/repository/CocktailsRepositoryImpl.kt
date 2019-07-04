package com.nyinyihtunlwin.data.repository

import com.nyinyihtunlwin.data.datasource.cache.CacheCocktailDataSource
import com.nyinyihtunlwin.data.datasource.remote.NetworkCocktailDataSource
import com.nyinyihtunlwin.data.mapper.CocktailMapper
import com.nyinyihtunlwin.domain.model.cocktail.Cocktail
import com.nyinyihtunlwin.domain.repository.CocktailsRepository
import io.reactivex.Observable

class CocktailsRepositoryImpl(
    private val networkCocktailDataSource: NetworkCocktailDataSource,
    private val cacheCocktailDataSource: CacheCocktailDataSource,
    private val cocktailMapper: CocktailMapper
) : CocktailsRepository {

    override fun getCocktails(type: String): Observable<List<Cocktail>> {
        return networkCocktailDataSource.getCocktails(type)
            .map { cocktailMapper.mapCocktailsList(it.drinks) }
    }

    override fun getCocktailDetails(id: String): Observable<Cocktail> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}