package com.example.login.network

import com.example.login.model.SendOtpRequest
import com.example.login.model.SendOtpResponse
import com.example.login.model.VerifyOtpRequest
import com.example.login.model.VerifyOtpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface LoginApiService{
    @POST("gateway/api/v1/sessions/login")
    fun sendOtp(@Header("Authorization") token : String, @Body requestBody : SendOtpRequest) : Call<SendOtpResponse>

    @POST("gateway/api/v1/sessions/verifyotp")
    fun verifyOtp(@Header("Authorization") token : String, @Body requestBody : VerifyOtpRequest) : Call<VerifyOtpResponse>
}