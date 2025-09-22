package com.example.mod4viewmodel_vendredi

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
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mod4viewmodel_vendredi.ui.theme.DemonstrationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemonstrationsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PageNotes(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun PageNotes(modifier: Modifier = Modifier,vm : NotesViewModel = viewModel()) {
    var noteForm by remember { mutableStateOf("") }
    val notes by vm.notes.collectAsState()
    Column(modifier.padding(16.dp)){
        LazyColumn {
            items(notes){Text(it.toString())}
        }
        Row{
            TextField(noteForm, onValueChange = {noteForm = it})
            Button({vm.addNote(noteForm.toDouble())}) {Text("Valider") }
        }
    }
}