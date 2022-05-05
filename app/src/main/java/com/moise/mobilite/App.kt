package com.moise.mobilite

import android.app.Application
import com.parse.Parse

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize The Parse server
        Parse.initialize(
            Parse.Configuration.Builder(this)
                .applicationId(BuildConfig.BACK4APP_APP_ID)
                .clientKey(BuildConfig.BACK4APP_CLIENT_KEY)
                .server(BuildConfig.BACK4APP_SERVER_URL)
                .build())
    }
}