package com.example.mod3compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.mod3compose.ui.theme.DemonstrationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemonstrationsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Text("Hello",modifier = Modifier.padding(innerPadding))
                ColonneIntro(Modifier.padding(innerPadding))
                }
            }
        }
    }
}
@Composable
fun ColonneIntro(modifier : Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment  =Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Text("Hello tout le monde")
        Icon(
            Icons.Default.MonetizationOn,
            contentDescription = "Edition",
        )
        Button(onClick = {}) {
            Text("Appuyer ici ne fais rien")
        }
        NotifBadge(Modifier.size(75.dp))
    }
}
@Composable
fun NotifBadge(modifier: Modifier = Modifier) {
    Box(modifier =modifier,Alignment.BottomStart){
        AsyncImage(
            model="https://lookaside.fbsbx.com/elementpath/media/?media_id=1515764255735341&version=1723113684",
            contentDescription = "Icône instagram"
        )
        Box(
            modifier = Modifier.padding(start=8.dp,bottom=8.dp)
                .align(Alignment.TopEnd)
                .clip(CircleShape)
                .size(32.dp)
                .background(Color.Red),
            contentAlignment = Alignment.Center
        ) {
            Text("1", color = Color.White)
        }
    }
}

