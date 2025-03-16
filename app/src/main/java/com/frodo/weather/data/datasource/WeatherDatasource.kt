package com.frodo.weather.data.datasource

import android.util.Log
import com.frodo.weather.data.model.GEOJsonResponse
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get

class WeatherDatasource {
    private val ktorHttpClient = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    suspend fun getWeaherData(): GEOJsonResponse {
        try {
            return ktorHttpClient.get("https://in2000.api.met.no/weatherapi/metalerts/2.0/current.json")
        } catch (e: Exception) {
            Log.d("WeatherDatasource", "Error fetching weather data: ${e.message}")
            return GEOJsonResponse(emptyList())
        }
    }
}