package com.ca1.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {

    val Log = Logger.getLogger(MainActivity::class.java.name)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.info("call onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.info("call onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.info("call onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.info("call onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.info("call onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.info("call onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.info("call onDestroy")
    }

}