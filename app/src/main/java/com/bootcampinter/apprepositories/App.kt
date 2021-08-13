package com.bootcampinter.apprepositories

import android.app.Application
import com.bootcampinter.apprepositories.data.di.DataModule
import com.bootcampinter.apprepositories.domain.di.DomainModule
import com.bootcampinter.apprepositories.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
        }

        DataModule.load()
        DomainModule.load()
        PresentationModule.load()
    }
}