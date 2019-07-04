package com.nyinyihtunlwin.cocktails.di

import com.nyinyihtunlwin.cocktails.executor.UiThread
import com.nyinyihtunlwin.data.database.RoomDbHelper
import com.nyinyihtunlwin.data.executor.BackgroundThreadImpl
import com.nyinyihtunlwin.data.executor.JobsExecutor
import com.nyinyihtunlwin.domain.executor.BackgroundThread
import com.nyinyihtunlwin.domain.executor.PostExecutionThread
import org.koin.dsl.module.module

val appModule = module {

    single { UiThread() as PostExecutionThread }

    single<BackgroundThread> { BackgroundThreadImpl(JobsExecutor()) }

    single { RoomDbHelper(get()) }

}