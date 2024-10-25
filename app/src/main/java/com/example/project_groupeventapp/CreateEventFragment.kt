package com.example.project_groupeventapp.ui.event

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.project_groupeventapp.databinding.FragmentCreateEventBinding
import java.util.Calendar
import androidx.navigation.fragment.findNavController
import com.example.project_groupeventapp.R

class CreateEventFragment : Fragment() {

    private var _binding: FragmentCreateEventBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateEventBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Handle Date Picker
        binding.etStartDate.setOnClickListener {
            showDatePicker()
        }

        // Handle Time Picker
        binding.etStartTime.setOnClickListener {
            showTimePicker()
        }

        // Handle Privacy Option
        binding.radioGroupPrivacy.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rbPublic -> handlePrivacySelection(true)
                R.id.rbPrivate -> handlePrivacySelection(false)
            }
        }

        // Handle Save and Continue Button Click
        binding.btnSaveAndContinue.setOnClickListener {
            saveEvent()
        }
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, year, month, dayOfMonth ->
                binding.etStartDate.setText("$year-${month + 1}-$dayOfMonth")
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }

    private fun showTimePicker() {
        val calendar = Calendar.getInstance()
        val timePickerDialog = TimePickerDialog(
            requireContext(),
            { _, hourOfDay, minute ->
                binding.etStartTime.setText(String.format("%02d:%02d", hourOfDay, minute))
            },
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            true
        )
        timePickerDialog.show()
    }

    private fun handlePrivacySelection(isPublic: Boolean) {
        if (isPublic) {
            binding.rbPublic.setBackgroundResource(R.drawable.selected_bg)
            binding.rbPrivate.setBackgroundResource(R.drawable.default_bg)
        } else {
            binding.rbPrivate.setBackgroundResource(R.drawable.selected_bg)
            binding.rbPublic.setBackgroundResource(R.drawable.default_bg)
        }
    }

    private fun saveEvent() {
        val eventName = binding.etEventName.text.toString().trim()
        val eventDescription = binding.etEventDescription.text.toString().trim()
        val startDate = binding.etStartDate.text.toString().trim()
        val startTime = binding.etStartTime.text.toString().trim()
        val location = binding.etLocation.text.toString().trim()
        val maxAttendees = binding.etMaxAttendees.text.toString().toIntOrNull()

        if (eventName.isEmpty() || startDate.isEmpty() || startTime.isEmpty() || location.isEmpty() || maxAttendees == null) {
            Toast.makeText(requireContext(), "Please fill all required fields", Toast.LENGTH_SHORT).show()
            return
        }

        // Save event data (you can save it locally, in a database, or send it to a server)
        Toast.makeText(requireContext(), "Event Saved!", Toast.LENGTH_SHORT).show()

        // Navigate to success screen
        findNavController().navigate(R.id.action_createEventFragment_to_guestListFragment)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}