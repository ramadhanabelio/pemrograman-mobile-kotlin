package com.onlineservice.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.onlineservice.databinding.ActivityLoginBinding
import com.onlineservice.helpers.SessionHandler
import com.onlineservice.models.LoginResponse
import com.onlineservice.models.User
import com.onlineservice.services.ServiceBuilder
import com.onlineservice.services.UserService
import retrofit2.Call
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private lateinit var bind: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val session = SessionHandler(applicationContext)
        if(session.isLoggedIn()){
            loadMainActivity()
        }

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        bind = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.tvDaftar.setOnClickListener{
            val intent = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(intent)
        }

        bind.btnLogin.setOnClickListener {
            val email = bind.etEmail.text.toString()
            val password = bind.etPassword.text.toString()

            if (TextUtils.isEmpty(email)){
                bind.etEmail.error = "Silahkan Isi Email Anda"
                bind.etEmail.requestFocus()
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(password)){
                bind.etPassword.error = "Silahkan Isi Password Anda"
                bind.etPassword.requestFocus()
                return@setOnClickListener
            }

            val filter = HashMap<String, String>()
            filter["email"] = email
            filter["password"] = password

            val userService: UserService =
                ServiceBuilder.buildService(UserService::class.java)
            val requestCall: Call<LoginResponse> =
                userService.loginUser(filter)

            requestCall.enqueue(object :
                retrofit2.Callback<LoginResponse>{
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(this@LoginActivity, "Error Terjadi Ketika Sedang Login: " + t.toString(), Toast.LENGTH_LONG).show()
                }

                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (!response.body()?.error!!) {
                        val loginResponse: LoginResponse? = response.body()
                        loginResponse?.let {
                            val user: User = loginResponse.data
                            session.saveUser(user)
                            Toast.makeText(this@LoginActivity,"Pengguna ${user.nama} dengan email ${user.email} berhasil login!" , Toast.LENGTH_LONG).show()
                            loadMainActivity()
                        }
                    } else {
                        Toast.makeText(this@LoginActivity,"Gagal Login: " + response.body()?.message, Toast.LENGTH_LONG).show()
                    }
                }
            })
        }
    }

    private fun loadMainActivity() {
        val intent = Intent(applicationContext, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}