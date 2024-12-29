@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.arfid

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.arfid.ui.theme.ARFIDTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

class AbschnittArfidVerstehen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ARFIDTheme {
                AbschnittArfidVerstehenScreen(context = this)
            }
        }
    }
}

@Composable
fun AbschnittArfidVerstehenScreen(context: Context) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { },
                navigationIcon = {
                    val context = LocalContext.current
                    IconButton(onClick = {

                        if (context is Activity) {
                            context.finish()
                        }
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_close),
                            contentDescription = "Schließen"
                        )
                    }
                },
                actions = {
                    val context = LocalContext.current
                    IconButton(onClick = {
                        val shareIntent = Intent().apply {
                            action = Intent.ACTION_SEND
                            putExtra(Intent.EXTRA_TEXT, "Ich möchte eine Info über ARFID teilen")
                            type = "text/plain"
                        }
                        context.startActivity(Intent.createChooser(shareIntent, "Share via"))
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_share),
                            contentDescription = "Teilen"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFB4D1D1)
                ),
                modifier = Modifier.fillMaxWidth()
            )


        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(0xFFFFFCFB))
        ) {
            // Bild oben
            Image(
                painter = painterResource(id = R.drawable.header_arfid_verstehen),
                contentDescription = "ARFID verstehen",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 10f),
                        contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.title_Slide_1),
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                )
                Text(
                    text = stringResource(id = R.string.content_Slide_1)
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            // Buttons unten
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp, horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { /* Zurück-Aktion */ },
                    enabled = false,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFECECEC),
                        contentColor = Color.Gray
                    ),
                    shape = RoundedCornerShape(100.dp)
                ) {
                    Text(text = "Zurück")
                }

                Button(
                    onClick = {
                        val intent = Intent(context, AbschnittSymptomeErkennen::class.java)
                        context.startActivity(intent)
                    },
                   modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFF7350),
                        contentColor = Color.White
                    )
                ) {
                    Text("Weiter")
                }
            }
        }
    }
}