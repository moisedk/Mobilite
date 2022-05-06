package com.moise.mobilite.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.moise.mobilite.R
import com.moise.mobilite.models.Ride

class HistoryAdapter(val context: Context, private val rideHistoryList: List<Ride>): RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(ride: Ride) {
            rideDescription.text = ride.getDescription()
            rideDate.text = ride.getDate().toString()
            if (ride.getCompleted()) {
                rideStatus.text = itemView.resources.getString(R.string.ride_finished)
                rideStatus.setTextColor(itemView.resources.getColor(R.color.secondary900))
            }
            else {
                rideStatus.text = itemView.resources.getString(R.string.cancelled)
                rideStatus.setTextColor(itemView.resources.getColor(R.color.primary900))
            }
        }

        private val rideDescription: TextView = view.findViewById(R.id.tvRideDescription)
        private val rideDate: TextView = view.findViewById(R.id.tvRideDateTime)
        private val rideStatus: TextView = view.findViewById(R.id.tvRideStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.history_item_list, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ride: Ride = rideHistoryList[position]
        holder.bind(ride)
    }

    override fun getItemCount() = rideHistoryList.size
}