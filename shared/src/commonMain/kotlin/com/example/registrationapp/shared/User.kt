package com.example.registrationapp.shared

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User (
        @SerialName("uname")
        val uname : String,
        @SerialName("mobile")
        val mobile : String,
        @SerialName("password")
        val password : String )