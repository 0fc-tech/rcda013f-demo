package com.example.mod6sqlite.model.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.mod6sqlite.model.db.BookContract.DATABASE_NAME
import com.example.mod6sqlite.model.db.BookContract.DATABASE_VERSION

class BookDbHelper(context: Context) : SQLiteOpenHelper(
    context,
    DATABASE_NAME,
    null,
    DATABASE_VERSION
) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(BookContract.SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int,
                           newVersion: Int) {
        db.execSQL(BookContract.SQL_DELETE_ENTRIES)
        onCreate(db)

    }
}