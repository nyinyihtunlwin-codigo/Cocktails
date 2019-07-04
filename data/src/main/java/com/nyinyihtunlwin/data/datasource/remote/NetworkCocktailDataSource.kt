package com.nyinyihtunlwin.data.datasource.remote

import com.google.gson.Gson
import com.nyinyihtunlwin.data.model.response.CocktailsListResponse
import com.nyinyihtunlwin.data.network.RestAdapter
import com.nyinyihtunlwin.data.network.service.CocktailService
import com.nyinyihtunlwin.domain.exception.ApiException
import com.nyinyihtunlwin.domain.exception.NetworkException
import io.reactivex.Observable
import java.io.IOException

class NetworkCocktailDataSource {

    private val mealService = RestAdapter.get().create(CocktailService::class.java)

    fun getCocktails(type: String): Observable<CocktailsListResponse> {
        return mealService.getCocktails(type)
            .map {
                try {
                    if (it.isSuccessful) it.body()
                    else {
                        val errorResponse =
                            Gson().fromJson(it.errorBody()?.charStream(), CocktailsListResponse::class.java)
                        throw ApiException("API Error")
                    }
                } catch (e: IOException) {
                    throw NetworkException
                }
            }
    }

}