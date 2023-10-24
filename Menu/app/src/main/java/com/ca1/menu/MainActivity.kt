package com.ca1.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.ca1.menu.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

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
            R.id.menuFile -> {
                showMessage("File menu")
                return true
            }
            R.id.menuEdit -> {
                showMessage("Edit menu")
                return true
            }
            R.id.menuHelp -> {
                showMessage("Help menu")
                return true
            }
            R.id.menuExit -> {
                showMessage("Exit")
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showMessage(msg:String) {
        Snackbar.make(binding.rootLayout, msg, Snackbar.LENGTH_LONG).show()
    }

}