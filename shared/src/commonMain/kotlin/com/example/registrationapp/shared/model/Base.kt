package com.example.registrationapp.shared.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Base (
    @SerialName("fields") val fields : Fields
)