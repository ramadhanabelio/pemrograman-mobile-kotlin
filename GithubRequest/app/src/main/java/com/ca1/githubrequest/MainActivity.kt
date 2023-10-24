package com.ca1.githubrequest

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import com.ca1.githubrequest.databinding.ActivityMainBinding
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGetInfo.setOnClickListener {
            Thread {
                val getGithubInfo = fetchGitHubInfo(binding.etSearchUser.text.toString())
                val jsonReader = JSONObject(getGithubInfo)
                runOnUiThread {
                    val id = jsonReader.getString("node_id")
                    val name = jsonReader.getString("name")
                    val url = jsonReader.getString("url")
                    val blog = jsonReader.getString("blog")
                    val bio = jsonReader.getString("bio")
                    val company = jsonReader.getString("company")
                    val avatarURL = jsonReader.getString("avatar_url")
                    binding.tvInfo.text = "${id}\n${name}\n${url}\n${blog}\n${bio}\n$company"
                    Glide.with(this).load(avatarURL).into(binding.imgProfil)
                }
            }.start()
        }
    }

    private fun fetchGitHubInfo(login_id: String): String {
        val url = "https://api.github.com/users/$login_id"
        val client = OkHttpClient()
        val request = Request.Builder().url(url).build()
        val response = client.newCall(request).execute()
        return response.body().string()
    }

    override fun onResume() {
        super.onResume()
        binding.etSearchUser.setText("")
        binding.etSearchUser.hint = "GitHub username..."
    }
}