package com.example.project_groupeventapp.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.project_groupeventapp.databinding.FragmentSuccessBinding
import com.example.project_groupeventapp.R

class SuccessFragment : Fragment() {

    private var _binding: FragmentSuccessBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSuccessBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Navigasi ke Profile ketika tombol 'Go to Profile' ditekan
        binding.btnGoToProfile.setOnClickListener {
            findNavController().navigate(R.id.action_successFragment_to_profileFragment)
        }

        // Navigasi ke Home ketika tombol 'Home' ditekan
        binding.btnGoHome.setOnClickListener {
            findNavController().navigate(R.id.action_successFragment_to_homeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
