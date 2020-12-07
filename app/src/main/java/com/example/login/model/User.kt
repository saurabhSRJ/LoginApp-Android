package com.example.login.model

import com.squareup.moshi.Json

class User {
    @Json(name = "id")
    var id: Int? = null

    @Json(name = "username")
    var username: Any? = null

    @Json(name = "email")
    var email: Any? = null

    @Json(name = "phone")
    var phone: String? = null

    @Json(name = "password")
    var password: Any? = null

    @Json(name = "isActive")
    var isActive: Boolean? = null

    @Json(name = "iamUserId")
    var iamUserId: Int? = null

    @Json(name = "created_at")
    var createdAt: String? = null

    @Json(name = "updated_at")
    var updatedAt: String? = null

    @Json(name = "deleted_at")
    var deletedAt: Any? = null

    @Json(name = "tms_tenant_id")
    var tmsTenantId: Int? = null
}