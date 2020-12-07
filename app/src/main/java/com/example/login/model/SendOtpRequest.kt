package com.example.login.model

import com.squareup.moshi.Json

data class SendOtpRequest(
    val channel : String,
    @Json(name = "phone_no")
    val phoneNumber : String
)