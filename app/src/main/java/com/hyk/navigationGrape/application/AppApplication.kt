package com.hyk.navigationGrape.application

import android.app.Application
import com.hyk.navigationGrape.preference.Preferences.preferencesInit

@Suppress("unused")
class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        preferencesInit()

    }
}