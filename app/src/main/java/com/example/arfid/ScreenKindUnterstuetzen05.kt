@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.arfid

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import com.example.arfid.ui.theme.ARFIDTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ScreenKindUnterstuetzen05 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ARFIDTheme {
                ScreenKindUnterstuetzen05(context = this)
            }
        }
    }
}

@Composable
fun ScreenKindUnterstuetzen05 (context: Context) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { },
                navigationIcon = {
                    IconButton(onClick = {
                        val intent = Intent(context, ParentActivity::class.java)
                        context.startActivity(intent)
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
                )
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(0xFFFFFCFB))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(bottom = 100.dp)

            ) {
                Image(
                    painter = painterResource(id = R.drawable.header_kind_unterstuetzen),
                    contentDescription = "ARFID verstehen",
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(16f / 10f),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = stringResource(id = R.string.kind_unterstuetzen_title_Slide_5),
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(16.dp)
                )
                Text(
                    text = stringResource(id = R.string.kind_unterstuetzen_slide_5_intro),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Text(
                    text = stringResource(id = R.string.kind_unterstuetzen_slide_5_bullet_point_1),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Text(
                    text = stringResource(id = R.string.kind_unterstuetzen_slide_5_bullet_point_2),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(16.dp)
                )

                Button(
                    onClick = {
                        // Platzhalter
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .padding(horizontal = 16.dp, vertical = 16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFEFEFEF),
                        contentColor = Color(0xFF004D40)
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_suche),
                            contentDescription = "Zur Expertensuche",
                            modifier = Modifier.size(32.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Zur Experten-Suche",
                            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp))
                    }
                }
            }


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(Color(0xFFFFFCFB))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp, horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    OutlinedButton(
                        onClick = {
                            val intent = Intent(context, ScreenKindUnterstuetzen04::class.java)
                            context.startActivity(intent)
                        },
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = Color(0xFFFFFFFF),
                            contentColor = Color(0xFFFF7350)
                        ),
                        border = BorderStroke(2.dp, Color(0xFFFF7350)),
                        shape = RoundedCornerShape(100.dp)
                    ) {
                        Text(text = "Zurück")
                    }

                    Button(
                        onClick = {
                            val intent = Intent(context, ScreenKindUnterstuetzen06::class.java)
                            context.startActivity(intent)
                        },
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 8.dp),
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
}
