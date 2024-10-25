package com.example.project_groupeventapp.ui.qrscanner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.project_groupeventapp.databinding.FragmentQRScannerBinding

class QRScannerFragment : Fragment() {

    private var _binding: FragmentQRScannerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQRScannerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Back button click listener
        binding.backButton.setOnClickListener {
            findNavController().navigateUp() // Navigasi kembali
        }

        // QR scan button click listener
        binding.btnScanQr.setOnClickListener {
            // Logic untuk scan QR bisa ditambahkan di sini
            // Untuk saat ini bisa arahkan ke fragment lain, misal success page
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
