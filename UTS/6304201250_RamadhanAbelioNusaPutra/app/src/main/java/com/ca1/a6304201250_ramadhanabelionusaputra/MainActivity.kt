package com.ca1.a6304201250_ramadhanabelionusaputra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ca1.a6304201250_ramadhanabelionusaputra.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Button Luas
        binding.btnLuas.setOnClickListener {
            try {
                val sisi = binding.etSisi.text.toString().toDouble()
                val luas = 6 * (sisi * sisi)
                binding.tvHasil.text = "Luas Kubus = $luas cm"
            } catch (error: java.lang.NumberFormatException) {
                Toast.makeText(applicationContext, "Cek inputan Anda!", Toast.LENGTH_SHORT).show()
                binding.tvHasil.text = "Cek Input Yaa!"
            }
        }

        // Button Volume
        binding.btnVolume.setOnClickListener {
            try {
                val sisi = binding.etSisi.text.toString().toDouble()
                val volume = sisi * sisi * sisi
                binding.tvHasil.text = "Volume Kubus = $volume cm3"
            } catch (error: java.lang.NumberFormatException) {
                Toast.makeText(applicationContext, "Cek inputan Anda!", Toast.LENGTH_SHORT).show()
                binding.tvHasil.text = "Cek Input Yaa!"
            }
        }

        // Button Reset
        binding.btnReset.setOnClickListener {
            binding.etSisi.setText("")
            binding.etSisi.requestFocus()
            binding.tvHasil.text = "Hasil"
        }

    }
}