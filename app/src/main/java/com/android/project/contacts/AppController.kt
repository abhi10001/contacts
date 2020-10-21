package com.android.project.contacts

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppController : Application(){
    override fun onCreate() {
        super.onCreate()
        DependencyInjector.start(this)
    }
}