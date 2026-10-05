package com.example.zakaria_3tia

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.zakaria_3tia.databinding.ActivityLoginAktivityBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import kotlin.math.log

class LoginAktivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginAktivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //   binding = ActivityLoginAktivityBinding.inflate(layoutInflater)
        //   setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //     val TombolLogin : Button = findViewById (R.id.button2)
        //     val Username    : EditText = findViewById (R.id.edtUsername)
        //    val Password    : EditText = findViewById (R.id.edtPassword)

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

    }}