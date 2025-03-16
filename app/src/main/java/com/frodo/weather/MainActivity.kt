package com.frodo.weather

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.frodo.weather.ui.theme.WeatherTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mapbox.geojson.Point
import com.mapbox.maps.extension.compose.MapboxMap
import com.mapbox.maps.extension.compose.animation.viewport.rememberMapViewportState


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { ApplicationTopAppBar("Weather") }) { innerPadding ->
                    MapBoxScreen(
                        modifier = Modifier .fillMaxSize().padding(innerPadding),
                        viewModel = viewModel()
                    )
                }
            }
        }
    }
}

@Composable
fun MapBoxScreen(modifier: Modifier, viewModel: WeatherViewModel) {
    viewModel.initialize()
    Log.d("MAPSCREEN", "Initialized")

    MapboxMap(
        modifier = Modifier.fillMaxSize(),
        mapViewportState = rememberMapViewportState {
            setCameraOptions {
                zoom(5.0)
                center(Point.fromLngLat(5.4, 60.4))
                pitch(0.0)
                bearing(0.0)
            }
        }
    )

}

@Composable
fun MainScreen(modifier: Modifier, viewModel: WeatherViewModel) {

    viewModel.initialize()
    //var response = viewModel.getWeather()



}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApplicationTopAppBar(title: String) {
    TopAppBar(
        title = {
            Text(text = title)
        }, colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        )
    )
}

