package com.example.arfid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.font.FontWeight
import com.example.arfid.ui.theme.ARFIDTheme
import androidx.compose.material3.Text as Text1
import androidx.compose.material3.ElevatedCard
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.res.stringResource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color






class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ARFIDTheme {
                Scaffold { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            ElevatedCardGreeting()
                            ElevatedCardKind()
                            ElevatedCardEltern()
                            ElevatedCardDoctor()
                        }
                        WeiterButton()
                    }
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text1(
        text = "Hello $name!",
        modifier = modifier
    )
}
@Composable
fun ElevatedCardGreeting() {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)

    ) {
        Text1(
            text = stringResource(R.string.Greeting),
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Left,
        )
    }
}


@Composable
fun ElevatedCardKind() {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Headline Text
            Text1(
                text = stringResource(R.string.card_kind_headline),
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Medium // Bold font for the headline
                ),
                modifier = Modifier.padding(bottom = 8.dp) // Space below the headline
            )

            // Subheadline Text
            Text1(
                text = stringResource(R.string.card_kind_subheadline),
                style = MaterialTheme.typography.bodyLarge // Regular body style for subheadline
            )
        }
    }
}

@Composable
fun ElevatedCardDoctor() {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Headline Text
            Text1(
                text = stringResource(R.string.card_fachkraefte_headline),
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Medium // Bold font for the headline
                ),
                modifier = Modifier.padding(bottom = 8.dp) // Space below the headline
            )

            // Subheadline Text
            Text1(
                text = stringResource(R.string.card_fachkraefte_subheadline),
                style = MaterialTheme.typography.bodyLarge // Regular body style for subheadline
            )
        }
    }
}

@Composable
fun ElevatedCardEltern() {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text1(
                text = stringResource(R.string.card_eltern_headline),
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Medium // Bold font for the headline
                ),
                modifier = Modifier.padding(bottom = 8.dp) // Space below the headline
            )

            Text1(
                text = stringResource(R.string.card_eltern_subheadline),
                style = MaterialTheme.typography.bodyLarge // Regular body style for subheadline
            )
        }
    }
}

@Composable
fun WeiterButton() {
    Button(
        onClick = {  },
        enabled = false,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(24.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFECECEC),
            contentColor = Color.Gray
        )
    ) {
        Text1("Weiter") // Button label
    }
}

@Preview(showBackground = true)
@Composable
fun ElevatedCardPreview() {
    ARFIDTheme {
        Column {
            ElevatedCardEltern()
            ElevatedCardKind()
                }
            }
        }
