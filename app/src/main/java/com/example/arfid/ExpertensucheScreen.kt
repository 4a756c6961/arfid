package com.example.arfid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults.textFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.arfid.ui.theme.ARFIDTheme
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState


class ExpertensucheScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpertensucheScreen()
        }
    }
}

@Composable
fun ExpertensucheScreen() {
    // Zugriff auf das TherapistRepository
    val context = LocalContext.current
    val expertenList = remember { ExpertenDaten(context) }

    var experten by remember { mutableStateOf<List<Experten>>(emptyList()) }
    var searchQuery by remember { mutableStateOf("") }

    // Lade die Daten mit einer Coroutine
    val scope = rememberCoroutineScope()

    LaunchedEffect(true) {
        // Hole die Experten-Daten asynchron
        experten = expertenList.getExperten()
    }

    // Filtere die Therapeuten basierend auf der Suchanfrage
    val filteredExperten = experten.filter {
        it.name.contains(searchQuery, ignoreCase = true) ||
                it.specialization.contains(searchQuery, ignoreCase = true) ||
                it.street.contains(searchQuery, ignoreCase = true)
    }

    // Initialisiere die Kamera
    val cameraPositionState = rememberCameraPositionState {
        position = com.google.android.gms.maps.model.CameraPosition.fromLatLngZoom(
            filteredExperten.firstOrNull()?.location ?: LatLng(54.0886707, 12.1400211),
            5f // Zoomlevel
        )
    }

    Column(modifier = Modifier.fillMaxSize()) {
        // Suchleiste
        SearchBar(
            query = searchQuery,
            onQueryChanged = { searchQuery = it.toString() }
        )

        // Google Map mit Markern
        GoogleMap(
            cameraPositionState = cameraPositionState,
            modifier = Modifier.fillMaxSize()
        ) {
            // Marker für die gefilterten Therapeuten
            filteredExperten.forEach { Experten ->
                Marker(
                    state = MarkerState(position = Experten.location),
                    title = Experten.name,
                    snippet = "Fachgebiet: ${Experten.specialization}\nAdresse: ${Experten.street}" // Adresse als Snippet anzeigen
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(query: String, onQueryChanged: (String) -> Unit) {
    TextField(
        value = query,  // String für den Wert verwenden
        onValueChange = onQueryChanged,
        placeholder = {
            Text(text = "Suche Experten...")
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = textFieldColors(
            focusedIndicatorColor = Color.Blue,
            unfocusedIndicatorColor = Color.Gray
        )
    )
}

@Preview
@Composable
fun ExpertensucheScreenPreview() {
    ARFIDTheme {
        ExpertensucheScreen()
    }
}
