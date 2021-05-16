package com.template.snave_kotlin

import android.app.Application
import android.content.Context
import androidx.lifecycle.LifecycleObserver
import androidx.multidex.MultiDex
import com.template.snave_kotlin.common.LocalStorage
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BaseApplication : Application(), LifecycleObserver {

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()

        LocalStorage.init(applicationContext)

        startKoin {
            androidLogger()
            androidContext(this@BaseApplication)
            // modules(listOf(appModules, appModuleV2))
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    companion object {
        private var instance: BaseApplication? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }

        fun getInstance(): BaseApplication? {
            return instance
        }
    }
}