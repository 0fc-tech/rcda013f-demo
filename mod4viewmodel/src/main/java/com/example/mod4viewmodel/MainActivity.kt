package com.example.mod4viewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mod4viewmodel.ui.theme.DemonstrationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemonstrationsTheme {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        NotesScreen(Modifier.padding(innerPadding))
                    }


            }
        }
    }
}

@Composable
fun NotesScreen(
    modifier: Modifier = Modifier,
    viewModel: NotesViewModel = viewModel()) {
    val notes by viewModel.notes.collectAsState()
    //val moyenne by viewModel.moyenne.collectAsState()

    var noteForm by rememberSaveable { mutableStateOf("")}
    Column(modifier.padding(32.dp)) {
        LazyColumn(modifier=Modifier.weight(1f)) {
            items(notes){
                note -> Text(note.toString())
            }
        }
       // Text("La moyenne est de $moyenne")
        //Formulaire
        Row {
            OutlinedTextField(noteForm, onValueChange = {noteForm = it})
            ElevatedButton(onClick = {
                viewModel.addNote(noteForm.toDouble())
                noteForm = ""
            }) {
                Icon(Icons.Default.Done, contentDescription = "Valider")
            }
        }
    }

}

