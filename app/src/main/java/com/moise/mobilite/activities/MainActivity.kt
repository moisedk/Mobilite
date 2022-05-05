package com.moise.mobilite.activities

import android.icu.text.TimeZoneFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.moise.mobilite.R
import com.parse.ParseObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testParseServer()
    }

    private fun testParseServer() {
        val parseObject = ParseObject("Class")
        parseObject.put("message", "This is just a message")
        parseObject.saveInBackground { exception ->
            if(exception != null) {
                exception.localizedMessage?.let { message -> Log.e(TAG, "testParseServer: $message", ) }
            }
            else {
                Log.d(TAG, "testParseServer: message saved!")
            }
        }
    }
    companion object {
        const val TAG = "MainActivity"
    }
}