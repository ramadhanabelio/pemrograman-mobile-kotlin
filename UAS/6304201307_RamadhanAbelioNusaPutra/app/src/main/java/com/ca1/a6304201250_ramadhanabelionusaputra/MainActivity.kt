package com.ca1.a6304201250_ramadhanabelionusaputra

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.ca1.a6304201250_ramadhanabelionusaputra.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuDashboard -> {
                startActivity(Intent(this@MainActivity, MainActivity::class.java))
            }
            R.id.menuCalculateDollar -> {
                startActivity(Intent(this@MainActivity, ConversionActivity::class.java))
            }
            R.id.menuAbout -> {
                startActivity(Intent(this@MainActivity, ProfileActivity::class.java))
            }
            R.id.menuCalculator -> {
                val intent = Intent()

                intent.action = Intent.ACTION_MAIN
                intent.addCategory(Intent.CATEGORY_APP_CALCULATOR)
                intent.flags =Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}