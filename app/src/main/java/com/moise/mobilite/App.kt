package com.moise.mobilite

import android.app.Application
import com.moise.mobilite.models.Ride
import com.parse.Parse
import com.parse.ParseObject

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        // Register the Ride class
        ParseObject.registerSubclass(Ride::class.java)
        // Initialize The Parse server
        Parse.initialize(
            Parse.Configuration.Builder(this)
                .applicationId(BuildConfig.BACK4APP_APP_ID)
                .clientKey(BuildConfig.BACK4APP_CLIENT_KEY)
                .server(BuildConfig.BACK4APP_SERVER_URL)
                .build())
    }
}