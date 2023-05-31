package com.development.unique_pacman.ui

import android.app.Application
import android.content.Context

class MyApp : Application() {
        override fun onCreate() {
            instance = this
            super.onCreate()
        }

        companion object {
            var instance: MyApp? = null
                private set

            // or return instance.getApplicationContext();
            val context: Context?
                get() = instance
            // or return instance.getApplicationContext();
        }
}