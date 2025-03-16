package com.frodo.weather

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.frodo.weather.data.datasource.WeatherDatasource
import com.frodo.weather.data.repository.WeatherRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel() : ViewModel() {
    val weatherRepository = WeatherRepository(weatherDatasource = WeatherDatasource())

    private val _names = MutableStateFlow<List<String>>(emptyList())
    val weatherData: StateFlow<List<String>> = _names.asStateFlow()

    fun addName(name: String) {
        viewModelScope.launch {
            Log.d("WeatherViewModel", "Launched")
            val response = weatherRepository.getWeaherData()
        }
    }

}