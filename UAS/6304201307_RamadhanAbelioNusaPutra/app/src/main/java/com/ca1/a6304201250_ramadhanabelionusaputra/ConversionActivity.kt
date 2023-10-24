package com.ca1.a6304201250_ramadhanabelionusaputra

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.ca1.a6304201250_ramadhanabelionusaputra.databinding.ActivityConversionBinding

class ConversionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConversionBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConversionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnConvert.setOnClickListener {
            try {
                val rupiah = binding.etMataUangRupiah.text.toString().toDouble()
                val dollar = rupiah / 15000
                val ringgit = rupiah / 3400
                binding.tvDollar.text = "$ Dollar $dollar"
                binding.tvRinggit.text = "Ringgit $ringgit"
            } catch (err: java.lang.NumberFormatException) {
                Toast.makeText(applicationContext, "Silahkan Cek Input", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuDashboard -> {
                startActivity(Intent(this@ConversionActivity, MainActivity::class.java))
            }
            R.id.menuCalculateDollar -> {
                startActivity(Intent(this@ConversionActivity, ConversionActivity::class.java))
            }
            R.id.menuAbout -> {
                startActivity(Intent(this@ConversionActivity, ProfileActivity::class.java))
            }
            R.id.menuCalculator -> {
                val intent = Intent()

                intent.action = Intent.ACTION_MAIN
                intent.addCategory(Intent.CATEGORY_APP_CALCULATOR)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

