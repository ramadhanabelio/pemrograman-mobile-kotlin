package com.onlineservice.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatDelegate
import com.onlineservice.databinding.ActivitySplashScreenBinding
import com.onlineservice.helpers.Config

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var bind: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(bind.root)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        Handler(mainLooper) .postDelayed ({
            startActivity (
                Intent (this, LoginActivity::class.java) )
            finish ()
        }, Config.SPLASH_SCREEN_DELAY)
    }
}