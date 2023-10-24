package com.ca1.savetocsv

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.ca1.savetocsv.databinding.ActivityMainBinding
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import com.github.doyaaaaaken.kotlincsv.dsl.csvWriter
import java.io.File
import java.io.IOException

class MainActivity : AppCompatActivity() {

    var baseDir = Environment.getExternalStorageDirectory().absolutePath
    var fileName = "test.csv"
    var filePath = baseDir + File.separator.toString() + fileName
    var myFile: File? = null

    // Storage Permissions
    private val REQUEST_EXTERNAL_STORAGE = 1
    private val PERMISSIONS_STORAGE = arrayOf(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (shouldAskPermissions()) {
            verifyStoragePermissions(this)
        }
    }
    private fun shouldAskPermissions(): Boolean {
        return Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1
    }
    private fun verifyStoragePermissions(activity: Activity?) {
        // Check if we have write permission
        val permission = ActivityCompat.checkSelfPermission(activity!!,
            Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                activity,
                PERMISSIONS_STORAGE,
                REQUEST_EXTERNAL_STORAGE
            )
        }
    }

    fun saveData(view: View){
        val xVal: String = binding.etX.text.toString()
        val yVal: String = binding.etY.text.toString()
        val zVal: String = binding.etZ.text.toString()
        val rows = listOf(xVal, yVal, zVal)
        try {
            csvWriter().open(filePath, append = true) {
                writeRow(rows)
            }
            Toast.makeText(applicationContext, "Data berhasil di simpan!",
                Toast.LENGTH_SHORT).show()
        } catch (e: IOException) {
            Toast.makeText(applicationContext, "Data tidak berhasil di simpan!$e", Toast.LENGTH_SHORT).show()
        }
    }
    fun readData(view: View){
        myFile = File(filePath)
        // File exist
        if (myFile!!.exists() && !myFile!!.isDirectory) {
            val rows: List<List<String>> = csvReader().readAll(myFile!!)
            var baris = ""
            var koma = ","
            for (row in rows){
                baris += row[0] + koma + row[1] + koma + row[2] + "\n"
            }
            binding.tvData.text = baris
        } else {
            Toast.makeText(applicationContext, "File csv belum dibuat!",
                Toast.LENGTH_SHORT).show()
        }
    }
}
