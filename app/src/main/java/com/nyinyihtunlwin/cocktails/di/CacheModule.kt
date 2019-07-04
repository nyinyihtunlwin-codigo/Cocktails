package com.nyinyihtunlwin.cocktails.di

import com.nyinyihtunlwin.data.datasource.cache.CacheCocktailDataSource
import org.koin.dsl.module.module

val cacheModule = module {

    single { CacheCocktailDataSource(get()) }

}