package com.ca1.sharedpreferences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ca1.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val filename = "$packageName TESTFILE"
        val pref = getSharedPreferences(filename, Context.MODE_PRIVATE)

        binding.btnsave.setOnClickListener {
            val editor = pref.edit()
            editor.putString("lastname", binding.txtlastname.text.toString())
            editor.putString("firstname", binding.txtfirstname.text.toString())
            editor.apply()
            Toast.makeText(this, "Saved data", Toast.LENGTH_LONG).show()
        }

        binding.btnload.setOnClickListener {
            val mlastname = pref.getString("lastname", "")
            val mfirstname = pref.getString("firstname", "")
            val moutput = "$mfirstname $mlastname"
            binding.txtoutput.text = moutput
        }

        binding.btnSecondActivity.setOnClickListener{
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        binding.txtfirstname.setText("")
        binding.txtlastname.setText("")
        binding.txtfirstname.hint = "first name"
        binding.txtlastname.hint = "last name"
        binding.txtoutput.text=""
    }
}
