package com.example.project_groupeventapp.ui.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project_groupeventapp.Event
import com.example.project_groupeventapp.databinding.FragmentCalendarBinding
import com.example.project_groupeventapp.ui.home.EventAdapter

class CalendarFragment : Fragment() {

    private var _binding: FragmentCalendarBinding? = null
    private val binding get() = _binding!!

    private lateinit var eventAdapter: EventAdapter
    private val events = mutableListOf<Event>() // Data untuk Upcoming Events

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentCalendarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up RecyclerView untuk Upcoming Events
        eventAdapter = EventAdapter(
            events = events,
            showDescription = true,   // Menampilkan deskripsi acara
            showStatus = true,        // Menampilkan status (Ongoing/Upcoming)
            showJoinButton = false    // Tidak menampilkan tombol Join di Calendar
        )
        binding.rvUpcomingEvents.layoutManager = LinearLayoutManager(requireContext())
        binding.rvUpcomingEvents.adapter = eventAdapter

        loadEvents() // Memuat daftar acara
    }

    private fun loadEvents() {
        // Data contoh untuk acara Upcoming
        events.add(Event("Tech Conference", "12 Okt", "Ongoing", "AI and the Future"))
        events.add(Event("Music Festival", "15 Okt", "Upcoming", "Live Performances"))
        events.add(Event("Art Exhibition", "20 Okt", "Upcoming", "Modern Art"))
        events.add(Event("Startup Meetup", "25 Okt", "Upcoming", "Networking Event"))
        events.add(Event("Science Fair", "30 Okt", "Upcoming", "Innovative Projects"))

        // Beri tahu adapter bahwa data telah berubah
        eventAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
