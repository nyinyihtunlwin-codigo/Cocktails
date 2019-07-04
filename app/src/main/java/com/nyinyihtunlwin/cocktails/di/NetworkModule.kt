package com.nyinyihtunlwin.cocktails.di

import com.nyinyihtunlwin.data.datasource.remote.NetworkCocktailDataSource
import org.koin.dsl.module.module

val networkModule = module {

    single { NetworkCocktailDataSource() }

}