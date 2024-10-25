package com.example.project_groupeventapp.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project_groupeventapp.R
import com.example.project_groupeventapp.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Back button functionality
        binding.backButton.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        // Sample data
        val notifications = listOf(
            NotificationItem("Event Entry Successful", "Just now", R.drawable.ic_success, R.drawable.ic_check),
            NotificationItem("Private Event Created", "2 minutes ago", R.drawable.ic_private_event, R.drawable.ic_lock),
            NotificationItem("Public Event Created", "5 minutes ago", R.drawable.ic_public_event, R.drawable.ic_public),
            NotificationItem("Event Full", "10 minutes ago", R.drawable.ic_event_full, R.drawable.ic_warning)
        )

        // Setup RecyclerView
        val adapter = NotificationsAdapter(notifications)
        binding.rvNotifications.layoutManager = LinearLayoutManager(requireContext())
        binding.rvNotifications.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
