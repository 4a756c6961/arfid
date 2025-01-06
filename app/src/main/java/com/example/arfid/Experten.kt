package com.example.arfid

import android.content.Context
import android.location.Geocoder
import com.google.android.gms.maps.model.LatLng
import java.util.Locale

data class Experten(
    val name: String,
    val specialization: String,
    val location: LatLng,
    val street: String,
    val houseNumber: String,
    val zipCode: String,
    val city: String
)

class ExpertenDaten(private val context: Context) {

    // Methode um Experten-Daten zu bekommen
    fun getExperten(): List<Experten> {
        return listOf(
            Experten(
                "Dr. Harald Schmidt",
                "Psychotherapeut",
                getLocationFromAddress(context, "Deutsche-med-platz 3, Rostock"), // Adresse geokodiert
                "Deutsche-med-platz",
                "3",
                "18057",
                "Rostock"
            ),
            Experten(
                "Dr. Cordula Weckmann",
                "Fachärztin für Psychiatrie",
                getLocationFromAddress(context, "Rolandufer 4, Berlin"),
                "Rolandufer",
                "4",
                "10115",
                "Berlin"
            ),
            Experten(
                "Wolfgang Heisel",
                "Ernährungsberater",
                getLocationFromAddress(context, "Zweibrückenstraße 2, München"),
                "Zweibrückenstraße",
                "2",
                "80331",
                "München"
            ),
            Experten(
                "Dr. Katharina Jung",
            "Fachärztin für Kinderheilkunde",
            getLocationFromAddress(context, "Hardefuststraße 1, Köln"),
            "Hardefuststraße",
            "1",
            "50677",
            "Köln"
        )
        )
    }
}

// Geokodierungsfunktion: Gibt die Koordinaten der Adresse zurück
fun getLocationFromAddress(context: Context, address: String): LatLng {
    val geocoder = Geocoder(context, Locale.getDefault())
    val addressList = geocoder.getFromLocationName(address, 1) // 1 steht für nur ein Ergebnis
    return if (!addressList.isNullOrEmpty()) {
        val location = addressList[0]
        LatLng(location.latitude, location.longitude) // Rückgabe der LatLng-Koordinaten
    } else {
        // Falls keine Adresse gefunden wird, eine Standardposition zurückgeben
        LatLng(0.0, 0.0) // Standardposition für Fehlerfälle
    }
}



