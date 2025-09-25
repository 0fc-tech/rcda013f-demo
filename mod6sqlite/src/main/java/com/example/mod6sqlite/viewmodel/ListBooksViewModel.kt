package com.example.mod6sqlite.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.mod6sqlite.model.Book
import com.example.mod6sqlite.model.BookDao
import com.example.mod6sqlite.model.db.BookDbHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListBooksViewModel(private val bookDao: BookDao) : ViewModel() {
    private val _books = MutableStateFlow<List<Book>>(emptyList())
    val books : StateFlow<List<Book>> = _books
    init {
        viewModelScope.launch {
            if(bookDao.getAllBooks().isEmpty()) {
                insertBook(
                    Book(
                        0L,
                        "Harry Potter 1",
                        "9782070541270",
                        "2000",
                        "Gallimard",
                        "J.K. Rowling"
                    )
                )
                insertBook(
                    Book(
                        0L,
                        "Harry Potter 2",
                        "9453126846652",
                        "2005",
                        "Gallimard",
                        "J.K. Rowling"
                    )
                )
                insertBook(
                    Book(
                        0L,
                        "Harry Potter 3",
                        "213578932323",
                        "2008",
                        "Gallimard",
                        "J.K. Rowling"
                    )
                )
                insertBook(
                    Book(
                        0L,
                        "Harry Potter 4",
                        "564135878946",
                        "2010",
                        "Gallimard",
                        "J.K. Rowling"
                    )
                )
                insertBook(
                    Book(
                        0L,
                        "Harry Potter 5",
                        "978207055466",
                        "2012",
                        "Gallimard",
                        "J.K. Rowling"
                    )
                )
                insertBook(
                    Book(
                        0L,
                        "Harry Potter 6",
                        "9782074532132",
                        "2014",
                        "Gallimard",
                        "J.K. Rowling"
                    )
                )
                insertBook(
                    Book(
                        0L,
                        "Harry Potter 7",
                        "54778275278",
                        "2016",
                        "Gallimard",
                        "J.K. Rowling"
                    )
                )
                insertBook(
                    Book(
                        0L,
                        "Seigneur des anneaux",
                        "9782070541270",
                        "2018",
                        "Senor G",
                        "Tolkien"
                    )
                )
                insertBook(
                    Book(
                        0L,
                        "Seigneur des anneaux 2",
                        "54864643587",
                        "2020",
                        "Senor G",
                        "Tolkien"
                    )
                )

            }
            loadBooks()
        }
    }
    //withContext nécessite le suspend
    private suspend fun loadBooks() {
        withContext(Dispatchers.IO) {
            val booksFromDb = bookDao.getAllBooks()
            _books.value = booksFromDb
        }
    }

    suspend fun insertBook(book: Book) {
        viewModelScope.launch(Dispatchers.IO) {
            bookDao.insertBook(book)
        }
    }
    companion object{
        val Factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val context = this[APPLICATION_KEY]?.applicationContext
                val bookDao = BookDao(BookDbHelper(checkNotNull(context)).writableDatabase)
                ListBooksViewModel(bookDao)
            }
        }
    }

}