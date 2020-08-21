package com.example.musicplayerandroidv2.room

import androidx.room.*

@Entity
class ArtistAlbum(  @PrimaryKey(autoGenerate = true)
               @ColumnInfo(name="id")
               var id: Int = 0,
               @ColumnInfo(name = "ArtistName")
               var name: String = "",
               @ColumnInfo(name = "Album")
               var Album: String = "",
               @ColumnInfo(name = "ImageAlbum")
               var ImageAlbum: String = ""
)  {

}


@Entity
class SongAlbum(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "songId")
    val songId: Int = 0,
    @ColumnInfo(name = "songAlbumId")
    val songAlbumId: Int,
    @ColumnInfo(name = "songName")
    val songName: String,
    @ColumnInfo(name = "songDuration")
    val songDuration: String
)

data class AlbumWithSong(
    @Embedded val album: ArtistAlbum,
    @Relation(
        parentColumn = "id",
        entityColumn = "songAlbumId"
    )
    val song: SongAlbum
)