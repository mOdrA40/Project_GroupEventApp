package com.example.project_groupeventapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project_groupeventapp.Event
import com.example.project_groupeventapp.databinding.FragmentHomeBinding
import androidx.navigation.fragment.findNavController
import com.example.project_groupeventapp.R

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var todayEventAdapter: EventAdapter
    private lateinit var upcomingEventAdapter: UpcomingEventAdapter
    private val todayEvents = mutableListOf<Event>() // Data untuk Today's Events
    private val upcomingEvents = mutableListOf<Event>() // Data untuk Upcoming Events

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up RecyclerView for Today's Events
        todayEventAdapter = EventAdapter(
            events = todayEvents,
            showDescription = false,  // Tidak menampilkan deskripsi di Home
            showStatus = true,        // Menampilkan status (Ongoing/Upcoming)
            showJoinButton = false    // Tidak menampilkan tombol Join
        )
        binding.rvTodayEvents.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTodayEvents.adapter = todayEventAdapter

        // Set up RecyclerView for Upcoming Events
        upcomingEventAdapter = UpcomingEventAdapter(upcomingEvents)
        binding.rvUpcomingEvents.layoutManager = LinearLayoutManager(requireContext())
        binding.rvUpcomingEvents.adapter = upcomingEventAdapter

        loadTodayEvents()
        loadUpcomingEvents()
        binding.ivProfile.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
        }
        binding.btnCreateEvent.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_createEventFragment)
        }


    }

    private fun loadTodayEvents() {
        // TODO: Load actual events from data source
        todayEvents.add(Event("Meeting with Client", "10:00 AM", "Ongoing", "")) // Deskripsi kosong
        todayEvents.add(Event("Team Lunch", "1:00 PM", "Upcoming", ""))
        todayEventAdapter.notifyDataSetChanged()
    }

    private fun loadUpcomingEvents() {
        // TODO: Load actual events from data source
        upcomingEvents.add(Event("Tech Conference", "25 Okt 2023, 09:00 AM", "", ""))
        upcomingEvents.add(Event("Marketing Workshop", "28 Okt 2023, 02:00 PM", "", ""))
        upcomingEventAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
