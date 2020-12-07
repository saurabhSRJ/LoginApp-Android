package com.example.login.model

import com.squareup.moshi.Json

data class VerifyOtpRequest(
    val otp : String,
    @Json(name = "phone_no")
    val phoneNumber : String
)