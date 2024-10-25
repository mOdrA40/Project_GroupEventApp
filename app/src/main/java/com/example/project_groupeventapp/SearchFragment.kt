package com.example.project_groupeventapp.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project_groupeventapp.Event
import com.example.project_groupeventapp.databinding.FragmentSearchBinding
import com.example.project_groupeventapp.ui.home.EventAdapter

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private lateinit var eventAdapter: EventAdapter
    private val events = mutableListOf<Event>() // Data untuk events
    private val categories = listOf("Teknologi", "Musik", "Olahraga") // Contoh kategori

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up RecyclerView for Categories (horizontal layout)
        binding.rvCategories.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvCategories.adapter = CategoryAdapter(categories)

        // Set up RecyclerView for Events
        eventAdapter = EventAdapter(
            events = events,
            showDescription = true,   // Menampilkan deskripsi di Search
            showStatus = false,       // Tidak menampilkan status di Search
            showJoinButton = true     // Menampilkan tombol Join di Search
        )
        binding.rvEventList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvEventList.adapter = eventAdapter

        loadEvents()
    }

    private fun loadEvents() {
        // TODO: Load actual events from data source
        events.add(Event("Tech Conference 2023", "25 Okt 2023, 09:00 AM", "Ongoing", "Konferensi teknologi terbesar"))
        events.add(Event("Java Jazz Festival", "26 Okt 2023, 03:00 PM", "Upcoming", "Festival musik jazz tahunan"))
        events.add(Event("Jakarta Marathon", "27 Okt 2023, 07:00 AM", "Upcoming", "Maraton terbesar di Jakarta"))
        eventAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
