package com.example.login.model

import com.squareup.moshi.Json


data class UserDetailResponse(
        @Json(name = "membership_activated")
        val membershipActivated: Boolean,

        @Json(name = "user_id")
        val userId: String,

        @Json(name = "name")
        val name: String,

        @Json(name = "gps_enabled")
        val gpsEnabled: Boolean,

        @Json(name = "membership_enabled")
        val membershipEnabled: Boolean,

        @Json(name = "newUser")
        val newUser: Boolean,

        @Json(name = "fleet_id")
        val fleetId: Int,

        @Json(name = "phone_no")
        val phoneNo: String,

        @Json(name = "has_address")
        val hasAddress: Boolean,

        @Json(name = "is_verified")
        val isVerified: Int,

        @Json(name = "referral_id")
        val referralId: Int? = null,

        @Json(name = "supportNumber")
        val supportNumber: String,

        @Json(name = "is_blocked_user")
        val isBlockedUser: Boolean? = null,

        @Json(name = "no_of_trucks")
        val noOfTrucks: Int = 0,

        @Json(name = "iam_id")
        val iamId: String
)
