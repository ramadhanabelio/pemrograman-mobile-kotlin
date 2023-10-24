package com.ca1.intent4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.ca1.intent4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add("Web")
        menu?.add("Map")
        menu?.add("Phone number")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var m_uri: Uri
        var m_intent: Intent = Intent()
        when (item?.toString()) {

            "Web" -> {
                m_uri = Uri.parse("https://www.dicoding.com")
                m_intent = Intent(Intent.ACTION_VIEW, m_uri)
            }

            "Map" -> {
                m_uri = Uri.parse("geo:25.362917, 49.563222")
                // This would have worked as well
                // m_uri = Uri.parse("https://maps.google.com/maps?q = 40.7113399, -74.0263469")
                m_intent = Intent(Intent(Intent.ACTION_VIEW, m_uri))
            }

            "Phone number" -> {
                m_uri = Uri.parse("tel:085274253902")
                m_intent = Intent(Intent.ACTION_DIAL, m_uri)
            }

        }

        startActivity(m_intent)
        return true

    }

}