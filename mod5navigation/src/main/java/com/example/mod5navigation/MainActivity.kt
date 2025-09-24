package com.example.mod5navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mod5navigation.ui.theme.DemonstrationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemonstrationsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavigationDemo(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun NavigationDemo(
    modifier: Modifier = Modifier,
    navController : NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = modifier
    ){
        composable("home") {
            HomePage(onSettingsClick = {
                navController.navigate("settings")
            })
        }
        composable("settings"){
            Text("Bienvenue chez Settings.",modifier = modifier)
        }
    }
}

@Composable
fun HomePage(modifier: Modifier = Modifier, onSettingsClick : () -> Unit) {
    Button({
        onSettingsClick()
    },modifier) {
        Text("Aller à Settings")
    }
}





