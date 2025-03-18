package com.frodo.weather

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.frodo.weather.data.datasource.WeatherDatasource
import com.frodo.weather.data.model.GEOJsonResponse
import com.frodo.weather.data.repository.WeatherRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {
    val weatherRepository = WeatherRepository(weatherDatasource = WeatherDatasource())

    private val _weatherData = MutableStateFlow<List<GEOJsonResponse>>(emptyList())
    val weatherData: StateFlow<List<GEOJsonResponse>> = _weatherData.asStateFlow()

    private var hasInitialized = false // Tilstand for å kontrollere initiering

    fun initialize() {
        Log.d("VIEWMODEL_WEATHER", "Weather Model initialized")
        if (!hasInitialized) {
            hasInitialized = true
        }
        getWeather()
    }

    fun getWeather() {
        viewModelScope.launch {
            Log.d("WeatherViewModel", "getWeather")
            try {
                val response = weatherRepository.getWeatherData()
                _weatherData.value = listOf(response) // Update the StateFlow with the new data
            } catch (e: Exception) {
                Log.e("WeatherViewModel", "Error fetching weather data", e)
                // Handle the error appropriately, e.g., show an error message to the user
            }
        }
    }
}