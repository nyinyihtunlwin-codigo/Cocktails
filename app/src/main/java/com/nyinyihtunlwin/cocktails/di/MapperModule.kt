package com.nyinyihtunlwin.cocktails.di

import com.nyinyihtunlwin.data.mapper.CocktailMapper
import org.koin.dsl.module.module

val mapperModule = module {

    single { CocktailMapper() }

}