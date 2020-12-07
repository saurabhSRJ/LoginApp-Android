package com.example.login.model

import com.squareup.moshi.Json

class VerifyOtpResponse {
    @Json(name = "user")
    var user: User? = null

    @Json(name = "isAdmin")
    var isAdmin: Boolean? = null

    @Json(name = "sessionKey")
    var sessionKey: String? = null

    @Json(name = "roles")
    var roles: List<Any>? = null

    @Json(name = "functions")
    var functions: List<Any>? = null
}

