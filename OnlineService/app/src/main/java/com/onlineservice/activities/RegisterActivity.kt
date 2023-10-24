package com.onlineservice.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.onlineservice.databinding.ActivityRegisterBinding
import com.onlineservice.models.DefaultResponse
import com.onlineservice.models.User
import com.onlineservice.services.ServiceBuilder
import com.onlineservice.services.UserService
import retrofit2.Call
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            val nama = binding.etNama.text.toString()
            val tanggalLahir = binding.etTanggalLahir.text.toString()
            val jenisKelamin = binding.spJenisKelamin.selectedItem.toString()
            val nomorHP = binding.etNomorHP.text.toString()
            val alamat = binding.etAlamat.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            val konfirmasiPassword = binding.etKonfirmasiPassword.text.toString()

            if (TextUtils.isEmpty(nama)){
                binding.etNama.error = "Nama Tidak Boleh Kosong"
                binding.etNama.requestFocus()
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(tanggalLahir)){
                binding.etTanggalLahir.error = "Tanggal Lahir Tidak Boleh Kosong"
                binding.etTanggalLahir.requestFocus()
                return@setOnClickListener
            }

            if (jenisKelamin.equals("Jenis Kelamin")){
                Toast.makeText(applicationContext, "Silahkan Pilih Jenis Kelamin", Toast.LENGTH_SHORT).show()
                binding.spJenisKelamin.requestFocus()
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(nomorHP)){
                binding.etNomorHP.error = "Nomor HP Tidak Boleh Kosong"
                binding.etNomorHP.requestFocus()
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(alamat)){
                binding.etAlamat.error = "Alamat Tidak Boleh Kosong"
                binding.etAlamat.requestFocus()
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(email)){
                binding.etEmail.error = "Email Tidak Boleh Kosong"
                binding.etEmail.requestFocus()
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(password)){
                binding.etPassword.error = "Password Tidak Boleh Kosong"
                binding.etPassword.requestFocus()
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(konfirmasiPassword)){
                binding.etKonfirmasiPassword.error = "Konfirmasi Password Tidak Boleh Kosong"
                binding.etKonfirmasiPassword.requestFocus()
                return@setOnClickListener
            }

            if (!password.equals(konfirmasiPassword)){
                binding.etKonfirmasiPassword.error = "Password dan Konfirmasi Password Tidak Sama"
                binding.etKonfirmasiPassword.requestFocus()
                return@setOnClickListener
            }

            val newUser = User(0, nama, tanggalLahir, jenisKelamin, nomorHP, alamat, email, password)
            val userService: UserService = ServiceBuilder.buildService(UserService::class.java)
            val requestCall: Call<DefaultResponse> = userService.registerUser(newUser)

            requestCall.enqueue(object :
            retrofit2.Callback<DefaultResponse>{
                override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
                    Toast.makeText(this@RegisterActivity, "Error Terjadi Ketika Sedang Mendaftarkan User: $t", Toast.LENGTH_LONG).show()
                }

                override fun onResponse(
                    call: Call<DefaultResponse>,
                    response: Response<DefaultResponse>
                ) {
                    if(!response.body()?.error!!) {
                        val defaultResponse: DefaultResponse = response.body()!!
                        defaultResponse.let {
                            Toast.makeText(this@RegisterActivity,defaultResponse.message, Toast.LENGTH_LONG).show()
                            val intent = Intent(applicationContext,LoginActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(intent)
                        }
                    } else {
                        Toast.makeText(this@RegisterActivity, "Gagal Mendaftarkan User: " + response.body()?.message, Toast.LENGTH_LONG).show()
                    }
                }
            })
        }
    }
}