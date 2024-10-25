package com.example.project_groupeventapp.ui.event

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project_groupeventapp.Guest
import com.example.project_groupeventapp.GuestAdapter
import com.example.project_groupeventapp.databinding.FragmentGuestListBinding


class GuestListFragment : Fragment() {

    private var _binding: FragmentGuestListBinding? = null
    private val binding get() = _binding!!

    private val guests = mutableListOf(
        Guest("John Smith", "RSVP confirmed"),
        Guest("Maria Garcia", "RSVP pending"),
        Guest("Liam Johnson", "RSVP confirmed"),
        Guest("Emma Brown", "RSVP pending"),
        Guest("Noah Davis", "RSVP confirmed")
    )

    private lateinit var guestAdapter: GuestAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGuestListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        guestAdapter = GuestAdapter(guests) { guest, isSelected ->
            guest.isSelected = isSelected
        }

        binding.rvGuestList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvGuestList.adapter = guestAdapter

        // Handle "Select All" checkbox
        binding.cbSelectAll.setOnCheckedChangeListener { _, isChecked ->
            guests.forEach { it.isSelected = isChecked }
            guestAdapter.notifyDataSetChanged()
        }

        // Handle "Send" button click
        binding.btnSend.setOnClickListener {
            // TODO: Handle send action
        }

        // Handle "Cancel" button click
        binding.btnCancel.setOnClickListener {
            // TODO: Handle cancel action
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
