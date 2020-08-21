package com.example.musicplayerandroidv2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.musicplayerandroidv2.R
import com.example.musicplayerandroidv2.room.ArtistAlbum
import com.example.musicplayerandroidv2.room.SongAlbum
import com.example.musicplayerandroidv2.viewmodelmusic.ViewModelMusic
import kotlinx.android.synthetic.main.fragment_add_list_music_album.*
import kotlinx.android.synthetic.main.fragment_add_music.*
import kotlinx.android.synthetic.main.fragment_add_music.saveNewMusic


class FragmentAddListMusicAlbum : Fragment(){
 val viewModelMusic by activityViewModels<ViewModelMusic>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_list_music_album, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val albumId = arguments?.getInt("albumId") ?: 1

        saveNewMusicAlbum.setOnClickListener {
            var judul= songTitle.text.toString()
            var waktu = timeMusic.text.toString()

            if (judul == "" || waktu == "") {
                return@setOnClickListener
            }

            viewModelMusic.insertNewSong(
               SongAlbum(songAlbumId = albumId,songName = judul,songDuration = waktu)
            )
            Toast.makeText(activity, "Added new music in Album", Toast.LENGTH_SHORT).show()
            activity?.onBackPressed()

        }

    }

}