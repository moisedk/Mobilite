package com.moise.mobilite.models

import com.parse.ParseClassName
import com.parse.ParseObject
import java.util.*

@ParseClassName("Ride")
class Ride : ParseObject() {
    fun getDescription(): String? {
        return getString(KEY_DESCRIPTION)
    }

    fun getDate(): Date? {
        return getDate(KEY_DATE)
    }

    fun getCompleted(): Boolean {
        return getBoolean(KEY_COMPLETED)
    }

    fun setDescription(desc: String) {
        put(KEY_DESCRIPTION, desc)
    }

    fun setDate(date: Date) {
        put(KEY_DATE, date)
    }

    fun setCompleted(completed: Boolean) {
        put(KEY_COMPLETED, completed)
    }

    companion object {

        const val KEY_DESCRIPTION = "description"
        const val KEY_DATE = "date"
        const val KEY_COMPLETED = "completed"

    }
}
