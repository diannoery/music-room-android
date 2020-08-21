package com.example.musicplayerandroidv2.viewmodelmusic

import android.app.Application
import androidx.lifecycle.*
import com.example.musicplayerandroidv2.room.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ViewModelMusic(application: Application) : AndroidViewModel(application){
//    val musicList = mutableListOf<SongList>(
//        SongList(
//            "Bara Suara",
//            "Sendu Melagu",
//            "https://3.bp.blogspot.com/-sxDtQMHxduk/V0Fk6GCS8AI/AAAAAAAAJzI/NvbPzdj1ZKsn_SutpicjoZQDDMH88NQlwCLcB/s1600/7.JPG"
//        ),
//        SongList(
//            "Danilla",
//            "Berdistraksi",
//            "https://pophariini.com/wp-content/uploads/2019/10/danillafingers-1.jpg"
//        ),
//        SongList(
//            ".feast",
//            "Padi Milik Rakyat",
//            "https://asset-a.grid.id/crop/0x0:0x0/700x0/photo/2018/09/27/170962345.jpg"
//        ),
//        SongList(
//            "FourTwnty",
//            "Nematomorpha",
//            "https://pophariini.com/wp-content/uploads/2018/09/Fourtwnty.jpg"
//        )
//    )
    //val musicLiveData: MutableLiveData<MutableList<SongList>> = MutableLiveData(musicList)

    private val repository =
        ArtisRepository(AppRoomDatabase.getDatabaseIntance(application).artistDao())
    fun getAllAlbum() = repository.getAllAlbum()

    fun getAlbumWithId(id: Int) = repository.getAlbumWithId(id)

    fun addMusic(album: ArtistAlbum) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.createNewAlbum(album)
        }
    }

    fun getSongWithAlbumId(id: Int) = repository.getSongWithAlbumId(id)

    fun insertNewSong(song: SongAlbum) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertNewSong(song)
        }
    }

//     init {
//         val artisDao= AppRoomDatabase.getDatabaseIntance(application).artistDao()
//         repository=ArtisRepository(artisDao)
//         allArtist=repository.allArtist
//     }

//    fun addMusic(artist: ArtistAlbum) {
////        musicList.add(SongList(album, artis, image))
////        musicLiveData.value = musicList
//        viewModelScope.launch(Dispatchers.IO){
//            repository.createArtist(artist)
//        }
//    }
}

