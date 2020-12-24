package com.example.login.model

import com.squareup.moshi.Json

data class FetchUserDetailRequest(
        @Json(name = "phone_no")
        val phoneNumber : String
        )
