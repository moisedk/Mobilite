package com.moise.mobilite.models

import java.util.*

class DataSource {

    companion object {
        fun getSampleRides(): List<Ride> {
            val ride1 = Ride()
            ride1.setDescription("Mother and Child Hospital")
            ride1.setDate(Calendar.getInstance().time)
            ride1.setCompleted(true)

            val ride2 = Ride()
            ride2.setDescription("Port Louis Casela Nature Park")
            ride2.setDate(Calendar.getInstance().time)
            ride2.setCompleted(true)

            val ride3 = Ride()
            ride3.setDescription("The City Orient Restaurant")
            ride3.setDate(Calendar.getInstance().time)
            ride3.setCompleted(false)

            val ride4 = Ride()
            ride4.setDescription("Train Ride Waterfront")
            ride4.setDate(Calendar.getInstance().time)
            ride4.setCompleted(false)
            return listOf(ride1, ride2, ride3, ride4)
        }
    }
}