package com.utm.stadydatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.utm.stadydatabase.databinding.ActivityMainBinding

import kotlinx.android.synthetic.main.fragment_start.*

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        APP = this

        navController = Navigation.findNavController(this, R.id.nav_fragment)

    }
}