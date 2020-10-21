package com.android.project.contacts

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

object DependencyInjector {
    fun start(application: Application){
        startKoin{
            androidContext(application)
           modules(contactsModule)
        }
    }
}