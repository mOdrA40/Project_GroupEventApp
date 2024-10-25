package com.example.project_groupeventapp.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.project_groupeventapp.databinding.FragmentEditProfileBinding
import com.example.project_groupeventapp.R

class EditProfileFragment : Fragment() {

    private var _binding: FragmentEditProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Navigasi ke halaman sebelumnya saat back button ditekan
        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }

        // Simpan perubahan profil
        binding.btnSaveProfile.setOnClickListener {
            findNavController().navigate(R.id.action_editProfileFragment_to_successFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
