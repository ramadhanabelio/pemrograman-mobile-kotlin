package com.onlineservice.services

import com.onlineservice.models.DefaultResponse
import com.onlineservice.models.LoginResponse
import com.onlineservice.models.User
import retrofit2.Call
import retrofit2.http.*

interface UserService {
    @PUT("users")
    fun updateUser(
        @Body updateUser: User
    ) : Call<DefaultResponse>

    @POST("users")
    fun registerUser(
        @Body newUser: User
    ) : Call<DefaultResponse>

    @GET("login")
    fun loginUser(
        @QueryMap filter: HashMap<String, String>
    ) : Call<LoginResponse>
}