package com.ca1.intent3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ca1.intent3.databinding.ActivityMainBinding

val SECOND_ACTIVITY = 1000

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.inputWeight.setHint("weight (lbs)")
        binding.inputHeight.setHint("height (inches)")
        binding.btnSendData.setOnClickListener {
            val m_intent = Intent(this@MainActivity, SecondActivity::class.java)
            val m_bundle = Bundle()
            Bundle()
            m_bundle.putFloat("weight", binding.inputWeight.text.toString().toFloat())
            m_bundle.putFloat("height", binding.inputHeight.text.toString().toFloat())
            m_intent.putExtra("main_activity_data", m_bundle)
            startActivityForResult(m_intent, SECOND_ACTIVITY)
        }
    }

    override fun onResume() {
        super.onResume()
        clearInputs()
    }

    private fun clearInputs() {
        binding.inputWeight.setText("")
        binding.inputHeight.setText("")
    }

    private fun getBMIDescription(bmi: Float) : String {
        return when (bmi) {
            in 1.0..18.5 -> "Underweight"
            in 18.6..24.9 -> "Normal weight"
            in 24.9..29.9 -> "Overweight"
            else -> "Obese"
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if ((requestCode == SECOND_ACTIVITY) and (resultCode == Activity.RESULT_OK)) {
            val bmi = data!!.getFloatExtra("second_activity_data", 1.0F)
            val bmiString = "%.2f" . format(bmi)
            binding.inputHeight.setText("")
            binding.inputWeight.setText("")
            binding.txtBmi.setText("BMI : $bmiString ${getBMIDescription(bmi)}")
        }
    }

}