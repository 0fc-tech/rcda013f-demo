package com.example.mod4compteur

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
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
import androidx.compose.ui.tooling.preview.Preview
import com.example.mod4compteur.ui.theme.DemonstrationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemonstrationsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RecetteCusine(Modifier.padding(innerPadding))
                }
            }
        }
    }
}
@Composable
fun RecetteCusine(modifier: Modifier = Modifier) {
    var nbPersonnes by remember {mutableIntStateOf(0)}
    Row(modifier = modifier) {
        IconButton(onClick = {nbPersonnes-=1}) { Icon(imageVector = Icons.Default.KeyboardArrowDown,contentDescription = null) }
        Text("Nombre de personnes : $nbPersonnes")
        IconButton(onClick = {nbPersonnes+=1}) { Icon(imageVector = Icons.Default.KeyboardArrowUp,contentDescription = null) }
    }
}