package com.frodo.weather.data.model

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class GEOJsonResponse(
    val features: List<Feature>,
    val lang: String,
    val lastChange: String,
    val type: String
)

@Serializable
data class Feature(
    val geometry: Geometry,
    val properties: Properties,
    val type: String,
    val alertWhen: AlertWhen
)

@Serializable
data class Geometry(
    val coordinates: List<List<List<@Contextual Any>>>,
    val type: String
)

@Serializable
data class Properties(
    val altitude_above_sea_level: Int,
    val area: String,
    val awarenessResponse: String,
    val awarenessSeriousness: String,
    val awareness_level: String,
    val awareness_type: String,
    val ceiling_above_sea_level: Int,
    val certainty: String,
    val consequences: String,
    val contact: String,
    val county: List<String>,
    val description: String,
    val event: String,
    val eventAwarenessName: String,
    val eventEndingTime: String,
    val geographicDomain: String,
    val id: String,
    val instruction: String,
    val resources: List<Resource>,
    val riskMatrixColor: String,
    val severity: String,
    val status: String,
    val title: String,
    val triggerLevel: String,
    val type: String,
    val web: String
)

@Serializable
data class Resource(
    val description: String,
    val mimeType: String,
    val uri: String
)

@Serializable
data class AlertWhen(
    val interval: List<String>
)

