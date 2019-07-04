package com.nyinyihtunlwin.cocktails.di

import com.nyinyihtunlwin.cocktails.feature.cocktails.list.CocktailsPresenter
import org.koin.dsl.module.module

val presenterModule = module {
    factory { CocktailsPresenter(get()) }
}