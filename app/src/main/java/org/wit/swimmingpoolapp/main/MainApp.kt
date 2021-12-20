package org.wit.swimmingpoolapp.main

import android.app.Application
import org.wit.swimmingpoolapp.models.SwimmingpoolappMemStore
import org.wit.swimmingpoolapp.models.SwimmingpoolappModel
import timber.log.Timber
import timber.log.Timber.i

class MainApp : Application() {

    val swimmingpoolapp = SwimmingpoolappMemStore()

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        i("Swimmingpoolapp started")

        //swimmingpoolapps.add(SwimmingpoolappModel("One", "About one..."))
        //swimmingpoolapps.add(SwimmingpoolappModel("Two", "About two..."))
        //swimmingpoolapps.add(SwimmingpoolappModel("Three", "About three..."))
    }
}