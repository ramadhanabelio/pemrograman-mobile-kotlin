package com.ca1.threadrunnable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import com.ca1.threadrunnable.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Percobaan 3 - - Menggunakan Kelas Handler
//    lateinit var mhandler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Percobaan 3 - Menggunakan Kelas Handler
//        mhandler = object : Handler() {
//            override fun handleMessage(msg: Message) {
//                binding.textView.text = msg?.data?.getString("counter")
//            }
//        }

        // Percobaan 1
        binding.button.setOnClickListener {
            val runnable = Worker()
            val thread = Thread(runnable)
            thread.start()
        }

        // Percobaan 2 & 3 - Menggunakan Kelas Handler
//        binding.button.setOnClickListener {
//            Thread(Runnable {
//                killSomeTime()
//            }).start()
//        }
    }

    // Percobaan 1
    inner class Worker : Runnable {
        override fun run() {
            killSomeTime()
        }
    }

    private fun killSomeTime() {
        for (i in 1..20) {
            Thread.sleep(2000)
            println("i: $i")
        }
    }

    // Percobaan 2 - Mengubah UI melalui Thread
//    private fun killSomeTime() {
//        for (i in 1..20) {
//            runOnUiThread(Runnable{
//                binding.textView.text = i.toString()
//            })
//            println("i:$i")
//            Thread.sleep(2000)
//        }
//    }

    // Percobaan 3 - Menggunakan Kelas Handler
//    private fun killSomeTime() {
//        for (i in 1..20) {
//            var msg = Message.obtain()
//            msg.data.putString("counter", i.toString())
//            Thread.sleep(2000)
//        }
//    }
}