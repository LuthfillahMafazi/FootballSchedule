package com.example.learnmvvm

import android.app.Application
import com.example.learnmvvm.di.myAppModule
import com.orhanobut.hawk.Hawk
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()

        Hawk.init(this).build()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MainApp)
            modules(myAppModule)
        }


    }
}