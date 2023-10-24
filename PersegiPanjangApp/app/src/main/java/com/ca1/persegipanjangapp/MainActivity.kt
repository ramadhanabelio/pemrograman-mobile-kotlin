package com.ca1.persegipanjangapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ca1.persegipanjangapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Button Luas
        binding.btnLuas.setOnClickListener {
            try {
                val panjang = binding.etPanjang.text.toString().toDouble()
                val lebar = binding.etLebar.text.toString().toDouble()
                val luas = panjang * lebar
                binding.tvHasil.text = "Luas Persegi Panjang = $luas cm2"
            } catch (error: java.lang.NumberFormatException) {
                Toast.makeText(applicationContext, "Cek inputan Anda!", Toast.LENGTH_SHORT).show()
                binding.tvHasil.text = "Cek Input Yaa!"
            }
        }

        // Button Keliling
        binding.btnKeliling.setOnClickListener {
            try {
                val panjang = binding.etPanjang.text.toString().toDouble()
                val lebar = binding.etLebar.text.toString().toDouble()
                val keliling = 2 * (panjang + lebar)
                binding.tvHasil.text = "Keliling Persegi Panjang = $keliling cm2"
            } catch (error: java.lang.NumberFormatException) {
                Toast.makeText(applicationContext, "Cek inputan Anda!", Toast.LENGTH_SHORT).show()
                binding.tvHasil.text = "Cek Input Yaa!"
            }
        }

        // Button Reset
        binding.btnReset.setOnClickListener {
            binding.etPanjang.setText("")
            binding.etPanjang.requestFocus()
            binding.etLebar.setText("")
            binding.tvHasil.text = "Hasil"
        }

    }
}