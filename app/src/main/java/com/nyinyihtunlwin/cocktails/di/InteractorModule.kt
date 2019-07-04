package com.nyinyihtunlwin.cocktails.di

import com.nyinyihtunlwin.domain.interactor.CocktailsInteractor
import org.koin.dsl.module.module

val interactorModule = module {

    factory { CocktailsInteractor(get(), get(), get()) }

}