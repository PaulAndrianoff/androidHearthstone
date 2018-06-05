package com.example.hp.myhearthstoneworkshop.main

import android.app.Application
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

    class hearthstoneApplication() : Application() {

        lateinit var requestQueue: RequestQueue

        companion object {
            lateinit var shared: hearthstoneApplication
        }

        override fun onCreate() {
            super.onCreate()

            shared = this

            requestQueue = Volley.newRequestQueue(applicationContext)
            requestQueue.start()
        }

    }
