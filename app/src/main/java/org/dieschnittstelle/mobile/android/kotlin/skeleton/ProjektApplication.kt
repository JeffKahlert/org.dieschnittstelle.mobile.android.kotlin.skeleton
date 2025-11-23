package org.dieschnittstelle.mobile.android.kotlin.skeleton

import android.app.Application

class ProjektApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}