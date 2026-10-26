package com.example.zakaria_3tia.Message.tutorial

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.zakaria_3tia.LoginActivity
import com.example.zakaria_3tia.databinding.ActivityTutorialMessageBinding

class TutorialMessageActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ONBOARDING = "extra_onboarding"
    }

    private lateinit var binding: ActivityTutorialMessageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTutorialMessageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentsList = listOf(
            Tutorial1Fragment(),
            Tutorial2Fragment(),
            Tutorial3Fragment()
        )
        val adapter = TutorialFragmentAdapter(this, fragmentsList)
        binding.tutorialMessageViewPager.adapter = adapter
        binding.dotIndicator.attachTo(binding.tutorialMessageViewPager)
    }

    // Dipanggil dari tombol Lewati / Mulai
    fun finishTutorial() {
        // Kalau dibuka dari Splash -> lanjut ke Login
        // Kalau dibuka dari ikon Info di tab Message -> cukup ditutup
        if (intent.getBooleanExtra(EXTRA_ONBOARDING, false)) {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        finish()
    }
}