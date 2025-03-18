package com.frodo.weather.data.datasource

import android.util.Log
import com.frodo.weather.data.model.GEOJsonResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.gson.gson

class WeatherDatasource {

    val client = HttpClient(Android){
        install(ContentNegotiation){
            gson()
        }

    }

    suspend fun getWeatherData(): GEOJsonResponse {
        try {
            Log.d("DEBUG", "Attempting to fetch GeoJSON data.")
            val response: HttpResponse = client.get("https://in2000.api.met.no/weatherapi/metalerts/2.0/current.json")
            Log.d("DEBUG", "Successfully retrieved data: $response")
            return response.body()
        } catch (e: Exception) {
            Log.e("ERROR", e.toString())
            return null
        }
    }
}