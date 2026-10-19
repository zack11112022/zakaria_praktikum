package com.example.zakaria_3tia

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.zakaria_3tia.databinding.ActivityBaseBinding
import com.example.zakaria_3tia.More.MoreFragment
import com.example.zakaria_3tia.Message.MessageFragment
import com.example.zakaria_3tia .Home.HomeFragment
import androidx.fragment.app.Fragment

class BaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBaseBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets
            ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
// bottom = 0
            insets

        }


// HomeFragment sebagai fragment default
        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
        }


        binding.bottomNav.setOnItemSelectedListener{
            when (it.itemId) {
                R.id.home -> {
                    replaceFragment(HomeFragment())

                    true
                }
                R.id.message -> {
                    replaceFragment(MessageFragment())

                    true
                }
                R.id.more -> {
                    replaceFragment(MoreFragment())

                    true
                }
                else ->
                    false
            }

        }
    }


    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            .commit()

// addToBackStack sengaja tidak dipakai: saat back langsung keluar aplikasi
    }
}