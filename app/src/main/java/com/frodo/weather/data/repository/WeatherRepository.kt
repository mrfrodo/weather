package com.frodo.weather.data.repository

import com.frodo.weather.data.datasource.WeatherDatasource
import com.frodo.weather.data.model.GEOJsonResponse

class WeatherRepository(private val weatherDatasource: WeatherDatasource) {
    suspend fun getWeaherData(): GEOJsonResponse {
        return weatherDatasource.getWeaherData()
    }
}