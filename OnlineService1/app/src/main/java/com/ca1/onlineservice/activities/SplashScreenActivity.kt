package herianto.ac.id.polbeng.onlineservice.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import herianto.ac.id.polbeng.onlineservice.databinding.ActivitySplashScreenBinding
import herianto.ac.id.polbeng.onlineservice.helpers.Config

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(mainLooper).postDelayed({
            startActivity(Intent(this@SplashScreenActivity,MainActivity::class.java))
            finish()
        }, Config.SPLASH_SCREEN_DELAY)
    }
}