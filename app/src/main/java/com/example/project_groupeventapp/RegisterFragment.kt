package com.example.project_groupeventapp

import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.project_groupeventapp.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth


class RegisterFragment : androidx.fragment.app.Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth

    private var isPasswordVisible = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        auth = FirebaseAuth.getInstance()

        // Tombol Back
        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }

        // Toggle Password Visibility
        binding.showPasswordButton.setOnClickListener {
            if (isPasswordVisible) {
                binding.passwordRegisterEditText.transformationMethod = PasswordTransformationMethod.getInstance()
                binding.showPasswordButton.setImageResource(R.drawable.ic_show_password)
                isPasswordVisible = false
            } else {
                binding.passwordRegisterEditText.transformationMethod = null
                binding.showPasswordButton.setImageResource(R.drawable.ic_hide_password)
                isPasswordVisible = true
            }
            // Pindahkan kursor ke akhir teks
            binding.passwordRegisterEditText.setSelection(binding.passwordRegisterEditText.text.length)
        }

        // Tombol Register
        binding.registerButton.setOnClickListener {
            val firstName = binding.firstNameEditText.text.toString().trim()
            val lastName = binding.lastNameEditText.text.toString().trim()
            val email = binding.emailRegisterEditText.text.toString().trim()
            val phone = binding.phoneEditText.text.toString().trim()
            val password = binding.passwordRegisterEditText.text.toString().trim()
            val termsAccepted = binding.termsCheckBox.isChecked

            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
                Toast.makeText(requireContext(), "Semua field harus diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!termsAccepted) {
                Toast.makeText(requireContext(), "Anda harus menyetujui syarat dan ketentuan", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Registrasi pengguna dengan Email dan Password
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(requireContext(), "Registrasi Berhasil", Toast.LENGTH_SHORT).show()

                        findNavController().navigate(R.id.action_register_to_login)
                    } else {
                        Toast.makeText(requireContext(), "Registrasi Gagal: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}