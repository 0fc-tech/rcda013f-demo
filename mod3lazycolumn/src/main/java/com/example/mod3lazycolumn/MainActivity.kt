package com.example.mod3lazycolumn

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mod3lazycolumn.ui.theme.DemonstrationsTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemonstrationsTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),) { innerPadding ->
                    val articles=List(100){"Article n°$it"}
                    LazyColumn(modifier = Modifier
                        .fillMaxWidth()
                        .padding(innerPadding)) {
                        items(articles){
                            Log.i("TAG", "onCreate: $it")

                            ElevatedCard(Modifier
                                .fillMaxSize()
                                .padding(8.dp)
                            ) {
                                ListItem(
                                    leadingContent = {
                                        Icon(
                                            Icons.Default.Edit,
                                            contentDescription = "")
                                    },
                                    headlineContent = {
                                        Text("$it",)
                                    },
                                    supportingContent = {
                                        Text("Sous-titre",)
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
