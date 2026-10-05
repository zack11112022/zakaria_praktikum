package com.example.zakaria_3tia

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.zakaria_3tia.databinding.ActivityLoginAktivityBinding

class LoginAktivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginAktivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // 1. Inisialisasi View Binding dan tampilkan layout
        binding = ActivityLoginAktivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 2. Atur Insets setelah layout terpasang
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 3. Listener Tombol Login
        binding.Login.setOnClickListener {
            val user = binding.edtUsername.text.toString()
            val pass = binding.edtPassword.text.toString()

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("username", user)
            intent.putExtra("password", pass)
            startActivity(intent)

            Log.d("Output", "Username $user Password $pass")
            Toast.makeText(this, "Username $user Password: $pass", Toast.LENGTH_LONG).show()
        }
    }
}