package com.onlineservice.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.onlineservice.databinding.ActivityEditProfileBinding
import com.onlineservice.helpers.SessionHandler
import com.onlineservice.models.DefaultResponse
import com.onlineservice.models.User
import com.onlineservice.services.ServiceBuilder
import com.onlineservice.services.UserService
import retrofit2.Call
import retrofit2.Response

class EditProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val session = SessionHandler(applicationContext)
        val user = session.getUser()
        if (user != null) {
            binding.etNama.setText(user.nama)
            binding.etTanggalLahir.setText(user.tanggalLahir)
            if (user.jeniskelamin.equals("Pria")) binding.spJenisKelamin.setSelection(1)
            else
                binding.spJenisKelamin.setSelection(2)
            binding.etNomorHP.setText(user.nomorHP)
            binding.etAlamat.setText(user.alamat)
            binding.etEmail.setText(user.email)
        }
        binding.btnSubmit.setOnClickListener {
            val id = user?.id!!
            val nama = binding.etNama.text.toString()
            val tanggalLahir = binding.etTanggalLahir.text.toString()
            val jenisKelamin = binding.spJenisKelamin.selectedItem.toString()
            val nomorHP = binding.etNomorHP.text.toString()
            val alamat = binding.etAlamat.text.toString()
            val email = binding.etEmail.text.toString()
            var password = binding.etPassword.text.toString()
            val konfirmasiPassword = binding.etKonfirmasiPassword.text.toString()

            if (TextUtils.isEmpty(nama)) {
                binding.etNama.error = "Nama tidak boleh kosong!"
                binding.etNama.requestFocus()
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(tanggalLahir)) {
                binding.etTanggalLahir.error = "Tanggal lahir tidak boleh kosong!"
                binding.etTanggalLahir.requestFocus()
                return@setOnClickListener
            }
            if (jenisKelamin.equals("Jenis Kelamin")) {
                Toast.makeText(
                    applicationContext,
                    "Silahkan pilih jenis kelamin!",
                    Toast.LENGTH_SHORT
                ).show()
                binding.spJenisKelamin.requestFocus()
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(nomorHP)) {
                binding.etNomorHP.error = "Nomor HP tidak boleh kosong!"
                binding.etNomorHP.requestFocus()
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(alamat)) {
                binding.etAlamat.error = "Alamat tidak boleh kosong!"
                binding.etAlamat.requestFocus()
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(email)) {
                binding.etEmail.error = "Email tidak boleh kosong!"
                binding.etEmail.requestFocus()
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(password) &&
                TextUtils.isEmpty(konfirmasiPassword)
            ) {
                password = ""
            } else {
                if (TextUtils.isEmpty(password)) {
                    binding.etPassword.error = "Password tidak boleh"
                    binding.etPassword.requestFocus()
                    return@setOnClickListener
                }
                if (TextUtils.isEmpty(konfirmasiPassword)) {
                    binding.etKonfirmasiPassword.setError("Konfirmasi password tidak boleh kosong!")
                    binding.etKonfirmasiPassword.requestFocus()
                    return@setOnClickListener
                }
                if (!password.equals(konfirmasiPassword)) {
                    binding.etKonfirmasiPassword.setError("Password dan konfirmasi password tidak sama!")
                    binding.etKonfirmasiPassword.requestFocus()
                    return@setOnClickListener
                }
            }
            val updatedUser =
                User(id, nama, tanggalLahir, jenisKelamin, nomorHP, alamat, email, password);
            val userService: UserService = ServiceBuilder.buildService(UserService::class.java)
            val requestCall: Call<DefaultResponse> = userService.updateUser(updatedUser)

            requestCall.enqueue(object : retrofit2.Callback<DefaultResponse> {
                override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
                    Toast.makeText(
                        this@EditProfileActivity,
                        "Error terjadi ketika sedang mengubah data user: " + t.toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }

                override fun onResponse(
                    call: Call<DefaultResponse>, response: Response<DefaultResponse>
                ) {
                    if (!response.body()?.error!!) {
                        val defaultResponse: DefaultResponse = response.body()!!
                        defaultResponse.let {
                            session.updateUser(updatedUser)
                            Toast.makeText(
                                this@EditProfileActivity,
                                defaultResponse.message,
                                Toast.LENGTH_LONG
                            ).show()
                            openMain()
                        }
                    } else {
                        Toast.makeText(
                            this@EditProfileActivity,
                            "Gagal mengubah user: " + response.body()?.message,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            })
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        openMain()
        return true
    }

    private fun openMain() {
        val intent = Intent(
            applicationContext,
            MainActivity::class.java)
        intent.putExtra ("fragment_id", 2)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or
                Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}
