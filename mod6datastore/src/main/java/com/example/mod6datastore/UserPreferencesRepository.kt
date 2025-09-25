package com.example.mod6datastore

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreferencesRepository(val context: Context) {
    //On accède au dataStore
    private val Context.dataStore by preferencesDataStore(name = "user_preferences")
    //On créé une clé qui stocke le fond écran en Entier
    private val KEY_BG_COLOR_SELECTED = intPreferencesKey("KEY_BG_COLOR_SELECTED")

    //On sauvegarde la couleur dans les Datastore à la clé KEY_BG_COLOR_SELECTED
    suspend fun saveBgColor(color: Color){
        context.dataStore.edit {
            it[KEY_BG_COLOR_SELECTED] = color.toArgb()
        }
    }

    fun getBgColor() : Flow<Color> {
        return context.dataStore.data.map {
            val color = it[KEY_BG_COLOR_SELECTED] ?: Color.White.toArgb()
            Color(color)
        }
    }
}