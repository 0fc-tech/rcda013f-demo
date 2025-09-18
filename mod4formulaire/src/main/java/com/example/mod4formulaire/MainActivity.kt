package com.example.mod4formulaire

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.mod4formulaire.ui.theme.DemonstrationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemonstrationsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Formulaire(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Formulaire(modifier: Modifier = Modifier) {
    var prenom = ""
    var nom by remember { mutableStateOf("") }
    var dateNaissance by rememberSaveable {mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    Column(modifier=modifier.fillMaxWidth().padding(16.dp)){
        OutlinedTextField(
            prenom,
            onValueChange = { prenom =it },
            label = {Text("Prénom") },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon ={ Icon(
                Icons.Default.Person,
                contentDescription = null,
            )},
        )
        Spacer(Modifier.padding(top = 16.dp))
        OutlinedTextField(
            nom,
            onValueChange = {nom =it},
            label = {Text("Nom")},
            modifier = Modifier.fillMaxWidth(),
            leadingIcon ={ Icon(
                Icons.Default.Person,
                contentDescription = null,
            )},
        )
        Spacer(Modifier.padding(top = 16.dp))

        OutlinedTextField(
            dateNaissance,
            onValueChange = {dateNaissance =it},
            label = {Text("Date Naissance")},
            modifier = Modifier.fillMaxWidth(),
            leadingIcon ={ Icon(
                Icons.Default.CalendarMonth,
                contentDescription = null,
            )},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions()
        )
        Spacer(Modifier.padding(top = 16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = {Text("Password")},
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            leadingIcon ={ Icon(
                Icons.Default.Password,
                contentDescription = null,
            )},
            trailingIcon = {
                val image = if (passwordVisible)
                    Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff
                val description = if (passwordVisible) "Hide password" else "Show password"
                Icon(
                    imageVector  = image,
                    description,
                    Modifier.clickable{passwordVisible = !passwordVisible}
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions()
        )
    }
}
