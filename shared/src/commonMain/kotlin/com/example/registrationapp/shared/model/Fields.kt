package com.example.registrationapp.shared.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Fields (
        @SerialName("uname")
        val uname : String,
        @SerialName("mobile")
        val mobile : String,
        @SerialName("password")
        val password : String )