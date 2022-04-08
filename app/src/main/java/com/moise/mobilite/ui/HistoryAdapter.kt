package com.moise.mobilite.ui

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.moise.mobilite.R

class HistoryAdapter(val context: Context, private val rideHistoryList: List<Ride>): RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(ride: Ride) {
            rideDescription.text = ride.description
            rideDate.text = ride.date.toString()
            if (ride.completed) {
                rideStatus.text = itemView.resources.getString(R.string.ride_finished)
                rideStatus.setTextColor(Color.GREEN)
            }
            else {
                rideStatus.text = itemView.resources.getString(R.string.cancelled)
                rideStatus.setTextColor(Color.RED)
            }
        }

        private val rideDescription: TextView = view.findViewById(R.id.tvRideDescription)
        private val rideDate: TextView = view.findViewById(R.id.tvRideDateTime)
        private val rideStatus: TextView = view.findViewById(R.id.tvRideStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryAdapter.ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.history_item_list, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HistoryAdapter.ViewHolder, position: Int) {
        val ride: Ride = rideHistoryList[position]
        holder.bind(ride)
    }

    override fun getItemCount() = rideHistoryList.size
}