package com.frodo.weather.data.model

import kotlinx.serialization.Serializable

@Serializable
data class GEOJsonResponse(
    val features: List<Feature>
)

@Serializable
data class Feature(
    val type: String,
    val geometry: Geometry,
    val properties: Properties,
    val whenDate: WhenDate
)

@Serializable
data class Geometry(
    val type: String,
    val coordinates: List<List<List<Double>>>
)

@Serializable
data class Properties(
    val area: String,
    val event: String,
    val description: String,
    val status: String,
    val title: String,
    val severity: String,
    val certainty: String,
    val county: List<String>,
    val municipality: List<String>,
    val resources: List<Resource>
)

@Serializable
data class Resource(
    val description: String,
    val mimeType: String,
    val uri: String
)

@Serializable
data class WhenDate(
    val interval: List<String>
)
