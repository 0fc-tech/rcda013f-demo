package com.example.mod4formulaire_vendredi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.mod4formulaire_vendredi.ui.theme.DemonstrationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemonstrationsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //Je renseigne mon padding dans mon composant (j'injecte les marges du scaffold dans le formulaire)
                    FormulaireInscription(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun FormulaireInscription(modifier: Modifier = Modifier) {
    var prenom = ""
    var nom by remember { mutableStateOf("") }
    var anneeNaissance by rememberSaveable { mutableStateOf("") }
    Column(modifier = modifier) {
        TextField(prenom, onValueChange = {prenom = it}, label = {Text("Prénom")})
        TextField(nom, onValueChange = {nom = it}, label = {Text("Nom")})
        TextField(anneeNaissance, onValueChange = {anneeNaissance = it}, label = {Text("Année naissance")})
        OutlinedButton(onClick = {

        }) {Text("Valider") }
    }
}







