package com.example.mod6room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
@Dao
interface MusicDao {
    @Insert
    suspend fun insertMusic(music: Music)

    @Query("SELECT * FROM music")
    suspend fun getAllMusics(): List<Music>

    @Query("SELECT * FROM music WHERE id = :id")
    suspend fun getMusicById(id:Long): List<Music>

}