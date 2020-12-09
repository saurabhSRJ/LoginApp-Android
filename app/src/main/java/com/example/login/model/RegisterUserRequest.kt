package com.example.login.model

import com.squareup.moshi.Json

data class RegisterUserRequest(
        @Json(name = "fleet_id")
        val fleetId : Int,
        val name : String,
        @Json(name = "no_of_trucks")
        val noOfTrucks : Int,
//        @Json(name = "referral_id")
//        val referralId: Int = 0
)
