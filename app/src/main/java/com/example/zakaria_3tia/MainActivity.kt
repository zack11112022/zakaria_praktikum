package com.example.zakaria_3tia

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.zakaria_3tia.pertemuan_5.LimaActivity
import com.example.zakaria_3tia.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Ambil data Intent dari LoginAktivity
        val user = intent.getStringExtra("username")
        val pass = intent.getStringExtra("password")

        // Disesuaikan: Menampilkan data pada ID textView2 yang ada di activity_main.xml
        binding.textView2.text = "Username: $user\nPassword: $pass"

        // Listener Tombol SnackBar
        binding.btnSnackBar.setOnClickListener {
            Snackbar.make(
                binding.root, "Halo ini Snackbar",
                Snackbar.LENGTH_LONG
            )
                .setAction("KEMBALI") {
                    finish() // Menutup MainActivity untuk kembali ke LoginAktivity
                }
                .show()
        }

        // Disesuaikan: Menggunakan ID btnAlertDialog sesuai dengan activity_main.xml
        binding.btnAlertDialog.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Hapus data")
                .setMessage("Data yang dihapus tidak bisa dikembalikan.")
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                }
                .setPositiveButton("Hapus") { dialog, _ ->
                    // Mengosongkan text pada textView2
                    binding.textView2.text = ""
                    dialog.dismiss()
                }
                .setCancelable(false)
                .show()
        }
        binding.btnToLima.setOnClickListener {
            startActivity(Intent(this, LimaActivity::class.java))

        }
    }}