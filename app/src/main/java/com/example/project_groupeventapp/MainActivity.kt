package com.example.project_groupeventapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.project_groupeventapp.databinding.ActivityMainBinding
import android.view.View

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up NavController dan BottomNavigationView
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController: NavController = navHostFragment.navController
        val bottomNavigationView: BottomNavigationView = binding.bottomNavigation

        // Listener untuk mendeteksi item yang diklik di BottomNavigationView
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    navController.navigate(R.id.navigation_home)
                    true
                }
                R.id.navigation_search -> {
                    navController.navigate(R.id.navigation_search)
                    true
                }
                R.id.navigation_calendar -> {
                    navController.navigate(R.id.navigation_calendar)
                    true
                }
                R.id.settingsFragment -> {
                    navController.navigate(R.id.settingsFragment)
                    true
                }
                else -> false
            }
        }

        // Hubungkan BottomNavigationView dengan NavController
        bottomNavigationView.setupWithNavController(navController)

        // Atur visibilitas BottomNavigationView sesuai fragment yang sedang ditampilkan
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.getStartedFragment, R.id.loginFragment, R.id.registerFragment -> {
                    // Sembunyikan BottomNavigationView di GetStarted, Login, dan Register
                    bottomNavigationView.visibility = View.GONE
                }
                else -> {
                    // Tampilkan BottomNavigationView di fragment lainnya
                    bottomNavigationView.visibility = View.VISIBLE
                }
            }
        }
    }
}
