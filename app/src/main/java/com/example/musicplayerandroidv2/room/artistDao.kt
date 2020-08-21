package com.example.musicplayerandroidv2.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface ArtistDao {
    @Transaction
    @Query("SELECT * FROM ArtistAlbum")
    fun getAlbumWithSong(): LiveData<List<AlbumWithSong>>

    @Query("SELECT * FROM ArtistAlbum")
    fun getAllAlbum(): LiveData<List<ArtistAlbum>>

    @Query(value = "SELECT * FROM ArtistAlbum WHERE id = :id")
    fun getAlbumWithId(id:Int): LiveData<ArtistAlbum>

    @Insert
    fun createNewAlbum(album: ArtistAlbum)

    @Query(value = "SELECT * FROM SongAlbum WHERE songAlbumId = :id")
    fun getSongWithAlbumId(id:Int): LiveData<List<SongAlbum>>

    @Insert
    fun insertNewSong(song: SongAlbum)


}