package com.example.project_groupeventapp.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project_groupeventapp.R
import com.example.project_groupeventapp.Event

class UpcomingEventAdapter(private val upcomingEvents: List<Event>) :
    RecyclerView.Adapter<UpcomingEventAdapter.UpcomingEventViewHolder>() {

    class UpcomingEventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val eventIcon: ImageView = itemView.findViewById(R.id.iv_event_icon)
        val eventTitle: TextView = itemView.findViewById(R.id.tv_event_title)
        val eventDateTime: TextView = itemView.findViewById(R.id.tv_event_date_time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingEventViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.upcoming_event_item, parent, false)
        return UpcomingEventViewHolder(view)
    }

    override fun onBindViewHolder(holder: UpcomingEventViewHolder, position: Int) {
        val event = upcomingEvents[position]
        holder.eventTitle.text = event.title
        holder.eventDateTime.text = event.time
        // Set event icon or other customizations
    }

    override fun getItemCount(): Int {
        return upcomingEvents.size
    }
}
