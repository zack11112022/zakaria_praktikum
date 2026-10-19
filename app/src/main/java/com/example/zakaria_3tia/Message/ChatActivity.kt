package com.example.zakaria_3tia.Message

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.zakaria_3tia.R
import com.example.zakaria_3tia.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val senderName = intent.getStringExtra("SENDER_NAME")
        val messageText = intent.getStringExtra("MESSAGE_TEXT")
        val avatarUrl = intent.getStringExtra("AVATAR_URL")

        supportActionBar?.title = senderName
        binding.chatSenderName.text = senderName
        binding.chatMessageText.text = messageText

        if (avatarUrl != null) {
            Glide.with(this)
                .load(avatarUrl)
                .into(binding.chatAvatarImg)
        }
    }
}