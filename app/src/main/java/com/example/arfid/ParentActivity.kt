package com.example.arfid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.arfid.ui.theme.ARFIDTheme


class ParentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ARFIDTheme {
                ParentScreen()
            }
        }
    }
}

@Composable
fun ParentScreen() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { ParentBottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") { ParentHomeScreen() }
            composable("wissen") { WissenScreen() }
            composable("expertensuche") { ExpertensucheScreen() }
            composable("forum") { ForumScreen() }
        }
    }
}

@Composable
fun ParentHomeScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        ElevatedCardContent(imageRes = R.drawable.arfid_verstehen)
        Spacer(modifier = Modifier.height(16.dp))
        ElevatedCardContent(imageRes = R.drawable.kind_unterstuetzen)
        Spacer(modifier = Modifier.height(16.dp))
        ElevatedCardContent(imageRes = R.drawable.erfahrungsberichte)
    }
}

@Composable
fun ElevatedCardContent(imageRes: Int) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))

        }
    }
}

@Composable
fun ParentBottomNavigationBar(navController: NavController) {
    val navItems = listOf(
        ParentNavItem("home", "Home", R.drawable.ic_home),
        ParentNavItem("wissen", "Wissen", R.drawable.ic_wissen),
        ParentNavItem("expertensuche", "Experten", R.drawable.ic_suche),
        ParentNavItem("forum", "Forum", R.drawable.ic_forum)
    )

    NavigationBar {
        val currentBackStackEntry = navController.currentBackStackEntryAsState().value
        val currentRoute = currentBackStackEntry?.destination?.route

        navItems.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.iconId),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = { Text(text = item.label) }
            )
        }
    }
}

data class ParentNavItem(
    val route: String,
    val label: String,
    val iconId: Int
)

@Preview(showBackground = true)
@Composable
fun ParentScreenPreview() {
    ARFIDTheme {
        ParentScreen()
    }
}