package com.example.registrationapp.shared

import kotlinx.serialization.Serializable

@Serializable
data class User (
    val name : String, val mobile : String, val password : String )