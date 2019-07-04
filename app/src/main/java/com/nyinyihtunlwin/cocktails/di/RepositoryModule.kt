package com.nyinyihtunlwin.cocktails.di

import com.nyinyihtunlwin.data.repository.CocktailsRepositoryImpl
import com.nyinyihtunlwin.domain.repository.CocktailsRepository
import org.koin.dsl.module.module

val repositoryModule = module {

    single<CocktailsRepository> { CocktailsRepositoryImpl(get(), get(), get()) }

}