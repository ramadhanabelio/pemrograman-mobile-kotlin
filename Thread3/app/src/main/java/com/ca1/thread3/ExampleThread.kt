package com.ca1.thread3

import android.util.Log

class ExampleThread : Thread {

    var seconds = 0
    val TAG = "MainActivity"

    constructor(seconds: Int) {
        this.seconds = seconds
    }

    override fun run() {
        for (i in 1 until  seconds) {
            Log.d(TAG, "startThread: $i")
            try {
                Thread.sleep(1000)
            } catch (ie: InterruptedException) {
                ie.printStackTrace()
            }
        }
    }
}