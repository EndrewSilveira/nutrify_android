package com.e.rezende.nutrify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.e.rezende.nutrify.presentation.base_components.PrimaryButton
import com.e.rezende.nutrify.presentation.theme.NutrifyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NutrifyTheme {
                Content()
            }
        }
    }
}

@Composable
fun Content() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            PrimaryButton(
                modifier = Modifier
                    .height(100.dp)
                    .width(200.dp),
                text = "Mais Detalhes",
                onClick = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NutrifyTheme {
        Content()
    }
}