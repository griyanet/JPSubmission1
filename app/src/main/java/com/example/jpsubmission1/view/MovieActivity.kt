package com.example.jpsubmission1.view

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.jpsubmission1.R
import com.example.jpsubmission1.databinding.ActivityMainBinding
import com.example.jpsubmission1.databinding.ActivityMovieBinding

class MovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.movies, R.id.favorites, R.id.tvShows
            )
        )
        binding.navView.setupWithNavController(navController)
        setupActionBarWithNavController(navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.splashPagerFragment || destination.id == R.id.splashFragment) {
                binding.navView.visibility = View.GONE
                supportActionBar?.hide()
            } else {
                binding.navView.visibility = View.VISIBLE
                supportActionBar?.show()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}