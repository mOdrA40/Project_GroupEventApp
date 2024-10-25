package com.example.project_groupeventapp.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project_groupeventapp.Event
import com.example.project_groupeventapp.R

class EventAdapter(
    private val events: List<Event>,
    private val showDescription: Boolean, // Kontrol visibilitas deskripsi
    private val showStatus: Boolean,      // Kontrol visibilitas status
    private val showJoinButton: Boolean   // Kontrol visibilitas tombol Join
) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val eventImage: ImageView = itemView.findViewById(R.id.iv_event_image)
        val eventTitle: TextView = itemView.findViewById(R.id.tv_event_title)
        val eventTime: TextView = itemView.findViewById(R.id.tv_event_time)
        val eventStatus: TextView = itemView.findViewById(R.id.tv_event_status)
        val joinButton: Button = itemView.findViewById(R.id.btn_join_event)
        val eventDescription: TextView = itemView.findViewById(R.id.tv_event_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.event_item, parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = events[position]
        holder.eventTitle.text = event.title
        holder.eventTime.text = event.time

        // Atur visibilitas deskripsi berdasarkan flag showDescription
        if (showDescription) {
            holder.eventDescription.visibility = View.VISIBLE
            holder.eventDescription.text = event.description
        } else {
            holder.eventDescription.visibility = View.GONE
        }

        // Atur visibilitas status berdasarkan flag showStatus
        if (showStatus) {
            holder.eventStatus.visibility = View.VISIBLE
            holder.eventStatus.text = event.status
        } else {
            holder.eventStatus.visibility = View.GONE
        }

        // Atur visibilitas tombol Join berdasarkan flag showJoinButton
        if (showJoinButton) {
            holder.joinButton.visibility = View.VISIBLE
        } else {
            holder.joinButton.visibility = View.GONE
        }

        // Handle Join button click
        holder.joinButton.setOnClickListener {
            // TODO: Add logic to join the event
        }
    }

    override fun getItemCount(): Int {
        return events.size
    }
}
