package com.example.mod5intentimplicite

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.mod5intentimplicite.ui.theme.DemonstrationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemonstrationsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GoToMap(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun GoToMap(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val requestPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ){isGranted->
        Intent(if(isGranted)
            Intent.ACTION_CALL
        else Intent.ACTION_DIAL,
            Uri.parse("tel:118-218")
        ).also { context.startActivity(it) }
    }
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()) {
        Button(onClick = {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("geo:48.0389467,-1.694974?q=ENI Campus Chartres de bretagne")
            )
            context.startActivity(intent)
        }) {
            Text("Aller à ENI RENNES")
        }
        Button(onClick = {
            val intent = Intent(
                Intent.ACTION_SEND,
                Uri.parse("sms:0612345678")
            )
            context.startActivity(intent)
        }) {
            Text("Envoyer un SMS")
        }
        Button(
            onClick = {
                requestPermissionLauncher.launch(android.Manifest.permission.CALL_PHONE)
            }
        ){
            Text("Appeler 118-218")
        }
    }
}






