package com.nyinyihtunlwin.data.network.service

import com.nyinyihtunlwin.data.model.response.CocktailDetailsResponse
import com.nyinyihtunlwin.data.model.response.CocktailsListResponse
import com.nyinyihtunlwin.data.network.URL
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface CocktailService {

    @GET(URL.ALCOHOLIC_COCKTAILS)
    fun getCocktails(@Query("a")type:String): Observable<Response<CocktailsListResponse>>

    @POST(URL.COCKTAIL_DETAILS)
    fun getCocktailDetails(cocktailId: String): Observable<Response<CocktailDetailsResponse>>

}