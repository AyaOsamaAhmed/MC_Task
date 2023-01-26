package com.aya.mc_task.base

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication : Application(){


    companion object {
     //   var prefs: SharedPrefsHelper? = null
    }

    override fun onCreate() {
        super.onCreate()
     //   prefs = SharedPrefsHelper(applicationContext)
        //    dbApp = individualsDataBase.getInstance(applicationContext)
    }


}
