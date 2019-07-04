package com.nyinyihtunlwin.cocktails

import android.app.Application
import com.nyinyihtunlwin.cocktails.di.*
import org.koin.android.ext.android.startKoin

class CocktailsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(
            applicationContext, listOf(
                appModule,
                mapperModule,
                networkModule,
                cacheModule,
                interactorModule,
                repositoryModule,
                presenterModule
            )
        )
    }

}