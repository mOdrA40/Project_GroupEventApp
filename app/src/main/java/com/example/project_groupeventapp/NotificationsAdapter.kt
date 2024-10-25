package com.example.project_groupeventapp.ui.notifications

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project_groupeventapp.R
import com.example.project_groupeventapp.databinding.ItemNotificationBinding

class NotificationsAdapter(private val notificationList: List<NotificationItem>) :
    RecyclerView.Adapter<NotificationsAdapter.NotificationViewHolder>() {

    inner class NotificationViewHolder(val binding: ItemNotificationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(notification: NotificationItem) {
            binding.tvNotificationTitle.text = notification.title
            binding.tvNotificationTime.text = notification.time
            binding.ivStatusIcon.setImageResource(notification.statusIconResId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val binding = ItemNotificationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotificationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.bind(notificationList[position])
    }

    override fun getItemCount(): Int {
        return notificationList.size
    }
}
