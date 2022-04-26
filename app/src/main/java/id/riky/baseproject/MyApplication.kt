@file:Suppress("unused")

package id.riky.baseproject

import android.app.Application
import id.riky.baseproject.di.networkModule
import id.riky.baseproject.di.repositoryModule
import id.riky.baseproject.di.useCaseModule
import id.riky.baseproject.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    networkModule,
//                    databaseModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}