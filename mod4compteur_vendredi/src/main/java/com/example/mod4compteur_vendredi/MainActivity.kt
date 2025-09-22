package com.example.mod4compteur_vendredi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.mod4compteur_vendredi.ui.theme.DemonstrationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemonstrationsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RecetteCuisine(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun RecetteCuisine(modifier: Modifier = Modifier) {
    var nbPersonnes by remember { mutableIntStateOf(0) }
    Row(modifier = modifier) {
        IconButton(onClick = {nbPersonnes-=1}) {Icon(Icons.Default.KeyboardArrowDown, contentDescription = "") }
        Text("$nbPersonnes nb personnes")
        IconButton(onClick = {nbPersonnes+=1}) {Icon(Icons.Default.KeyboardArrowUp, contentDescription = "") }

    }
}