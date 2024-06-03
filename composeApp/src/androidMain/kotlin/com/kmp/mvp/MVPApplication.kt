package com.kmp.mvp

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class MVPApplication : Application() {
    @SuppressLint("StaticFieldLeak")
    companion object {
        val mvp = MVP()
    }

    override fun onCreate() {
        super.onCreate()
        mvp.init(this)
    }
}

class MVP {
    var currentContext: Context? = null

    fun init(context: Context) {
        this.currentContext = context
    }
}