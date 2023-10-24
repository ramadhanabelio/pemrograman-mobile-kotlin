package com.ca1.intent3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ca1.intent3.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.getBundleExtra("main_activity_data")

        val height = bundle?.getFloat("height")
        val weight = bundle?.getFloat("weight")
        binding.txtIntentdata.text = "Height: $height | Weight: $weight"
        binding.btnCalculate.setOnClickListener {
            val m_intent = Intent()
            var m_bmi = 0F
            if( weight != null && height != null) {
                m_bmi = 703 * (weight / (height * height))
            }
            m_intent.putExtra("second_activity_data", m_bmi)
            setResult(Activity.RESULT_OK, m_intent)
            finish()
        }
    }

}