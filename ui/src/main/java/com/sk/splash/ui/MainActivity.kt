package com.sk.splash.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.sk.splash.ui.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hostFragment =
            supportFragmentManager.findFragmentById(binding.mainNavHostFragment.id) as NavHostFragment
        val controller = hostFragment.navController

        binding.bottomNav.setupWithNavController(controller)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.home, R.id.search, R.id.favorites))
        binding.toolbar.setupWithNavController(controller, appBarConfiguration)

        setSupportActionBar(binding.toolbar)
    }
}