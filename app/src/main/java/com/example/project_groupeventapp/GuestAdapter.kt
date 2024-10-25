package com.example.project_groupeventapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project_groupeventapp.R

class GuestAdapter(
    private val guests: List<Guest>,
    private val onGuestSelected: (Guest, Boolean) -> Unit
) : RecyclerView.Adapter<GuestAdapter.GuestViewHolder>() {

    class GuestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cbGuest: CheckBox = itemView.findViewById(R.id.cb_guest)
        val tvName: TextView = itemView.findViewById(R.id.tv_guest_name)
        val tvRsvpStatus: TextView = itemView.findViewById(R.id.tv_rsvp_status)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_guest, parent, false)
        return GuestViewHolder(view)
    }

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
        val guest = guests[position]
        holder.tvName.text = guest.name
        holder.tvRsvpStatus.text = guest.rsvpStatus
        holder.cbGuest.isChecked = guest.isSelected

        holder.cbGuest.setOnCheckedChangeListener { _, isChecked ->
            onGuestSelected(guest, isChecked)
        }
    }

    override fun getItemCount(): Int = guests.size
}
