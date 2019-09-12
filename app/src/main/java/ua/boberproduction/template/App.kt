package ua.boberproduction.template

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin
import timber.log.Timber
import ua.boberproduction.template.di.appModules


class App : Application() {
    private var androidDefaultUEH: Thread.UncaughtExceptionHandler? = null

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        androidDefaultUEH = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler(exceptionHandler)

        if (GlobalContext.getOrNull() == null) { // Workaround to make Koin work in Unit tests
            startKoin {
                androidContext(this@App)
                modules(appModules)
            }
        }
    }

    private val exceptionHandler = Thread.UncaughtExceptionHandler { t, e ->
        Timber.e(e, "Uncaught exception is: ")
        // log it & phone home.
        androidDefaultUEH?.uncaughtException(t, e)
    }
}