package com.example.login.model

import com.squareup.moshi.Json

data class VerifyOtpResponse (
    @Json(name = "user")
    val user: User,

    @Json(name = "isAdmin")
    val isAdmin: Boolean,

    @Json(name = "sessionKey")
    val sessionKey: String,

    @Json(name = "roles")
    val roles: List<Any>?,

    @Json(name = "functions")
    val functions: List<Any>,
)

