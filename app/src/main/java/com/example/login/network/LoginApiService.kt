package com.example.login.network

import com.example.login.model.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT

interface LoginApiService{
    @POST("gateway/api/v1/sessions/login")
    fun sendOtp(@Header("Authorization") token : String, @Body requestBody : SendOtpRequest) : Call<SendOtpResponse>

    @POST("gateway/api/v1/sessions/verifyotp")
    fun verifyOtp(@Header("Authorization") token : String, @Body requestBody : VerifyOtpRequest) : Call<VerifyOtpResponse>

    @POST("fms/api/fleetowner/verifyuser")
    fun fetchUser(@Header("Authorization") token: String, @Body requestBody : FetchUserDetailRequest) : Call<UserDetailResponse>

    @PUT("fms/api/fleetowner/v2/updateFleet")
    fun registerUser(@Header("Authorization") token: String, @Body requestBody:RegisterUserRequest) : Call<UserDetailResponse>
}