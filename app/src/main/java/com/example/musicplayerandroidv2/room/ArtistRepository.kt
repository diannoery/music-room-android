package com.example.musicplayerandroidv2.room

import androidx.lifecycle.LiveData


class ArtisRepository(private val artistDao: ArtistDao) {
     fun getAllAlbum() = artistDao.getAllAlbum()

    fun getAlbumWithId(id: Int) = artistDao.getAlbumWithId(id)

    fun createNewAlbum(album: ArtistAlbum) = artistDao.createNewAlbum(album)

    fun getSongWithAlbumId(id: Int) = artistDao.getSongWithAlbumId(id)

    fun insertNewSong(song: SongAlbum) = artistDao.insertNewSong(song)
}