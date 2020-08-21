package com.example.musicplayerandroidv2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import coil.api.load
import com.example.musicplayerandroidv2.R
import com.example.musicplayerandroidv2.recycleviewadapter.ListMusicAlbum
import com.example.musicplayerandroidv2.recycleviewadapter.MusicViewAdapter
import com.example.musicplayerandroidv2.viewmodelmusic.ViewModelMusic
import kotlinx.android.synthetic.main.fragment_detail_music.*
import java.util.Observer

class FragmentDetailMusic : Fragment() {

    val viewModelMusic by activityViewModels<ViewModelMusic>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_music, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val albumId = arguments?.getInt("albumId") ?: 1
        viewModelMusic.getAlbumWithId(albumId).observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            musicArtistNameDetail.text = it.name
            musicTitleDetail.text = it.Album
            musicImageDetail.load(it.ImageAlbum)
        } )

        songDetailRecycleView.layoutManager = LinearLayoutManager(activity)
        viewModelMusic.getSongWithAlbumId(albumId).observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            songDetailRecycleView.adapter = ListMusicAlbum(it)
        })

        addSongAlbum.setOnClickListener {
            val bundle = bundleOf(Pair("albumId",albumId))
            Navigation.findNavController(it).navigate(R.id.action_fragmentDetailMusic_to_fragmentAddListMusicAlbum,bundle)
        }


//        val album= arguments?.getString("album")
//        val musicArtistName = arguments?.getString("artist")
//        val musicImageURL = arguments?.getString("image")
//        musicImageDetail.load(musicImageURL)
//        musicArtistNameDetail.text = musicArtistName
//        musicTitleDetail.text = album

    }
}




