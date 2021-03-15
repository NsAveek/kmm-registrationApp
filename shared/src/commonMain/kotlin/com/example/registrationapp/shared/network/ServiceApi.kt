package com.example.registrationapp.shared.network

import com.example.registrationapp.shared.model.Base
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.*
import kotlinx.serialization.json.Json

class ServiceApi {
    companion object {

        private const val BASE_URL = "https://firestore.googleapis.com/v1/projects/"
        private const val PROJECT_URL = "kmm-registration/"
        private const val DATABASE_URL = "databases/(default)/documents/Users/"
        private const val USERS_ENDPOINT = "$BASE_URL$PROJECT_URL$DATABASE_URL"
        private const val FIELDS_DATA = "?mask.fieldPaths=mobile&mask.fieldPaths=password&mask.fieldPaths=uname&fields=fields"
//        user3@test.com
    }
    private val apiClient = HttpClient{
        install(JsonFeature){
            val json = Json { ignoreUnknownKeys = true }
            serializer = KotlinxSerializer(json)
        }
    }
    suspend fun getUser(userEmail  : String) : Base {
        val endpoint = USERS_ENDPOINT+userEmail+FIELDS_DATA
        return apiClient.get(endpoint)
    }
    suspend fun getAlternateUser(userEmail  : String) : Base {
        val secondaryEndPoint = ""
        val json = HttpClient().get<String>(secondaryEndPoint)
        return Json.decodeFromString(Base.serializer(), json)
    }
}