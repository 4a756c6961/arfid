package com.example.arfid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItems(
    val label: String,
    val icon:ImageVector,
    val route: String
)

val listOfNavItems = listOf(
    NavItems(
        label = "Expertennetzwerk",
        icon = Icons.Default.Home,
        route = Screens.ExpertennetzwerkScreen.name
    ),
    NavItems(
        label = "Nachrichten",
        icon = Icons.Default.Notifications,
        route = Screens.NachrichtenScreen.name
    ),
    NavItems(
        label = "Über ARFID",
        icon = Icons.Default.Person,
        route = Screens.ueber_arfid_screen.name
    ),
)