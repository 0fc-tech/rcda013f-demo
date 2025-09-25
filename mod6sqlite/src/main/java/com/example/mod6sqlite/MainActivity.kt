package com.example.mod6sqlite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mod6sqlite.ui.theme.DemonstrationsTheme
import com.example.mod6sqlite.viewmodel.ListBooksViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemonstrationsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BookScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun BookScreen(modifier: Modifier = Modifier,
               vm : ListBooksViewModel = viewModel(factory = ListBooksViewModel.Factory)
) {
    val books by vm.books.collectAsState()
    LazyColumn(modifier) {
        items(books){
            Text("Nom:" + it.name + " ISBN : " + it.isbn)
        }
    }
}