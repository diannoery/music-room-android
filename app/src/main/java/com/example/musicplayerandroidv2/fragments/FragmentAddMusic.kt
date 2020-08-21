package com.example.musicplayerandroidv2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.musicplayerandroidv2.R
import com.example.musicplayerandroidv2.room.ArtistAlbum
import com.example.musicplayerandroidv2.viewmodelmusic.ViewModelMusic
import kotlinx.android.synthetic.main.fragment_add_music.*


class FragmentAddMusic : Fragment(), View.OnClickListener {
        val musicViewModel by activityViewModels<ViewModelMusic>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_music, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        saveNewMusic.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val album= musicAlbum.text.toString()
        val artisName=ArtistName.text.toString()
        val imageMusic=ImageUrl.text.toString()

        when(v){
            saveNewMusic->{
                if (album == "" || artisName == "" || imageMusic == "") {
                    Toast.makeText(activity, "Cant input empty form, fill all the form", Toast.LENGTH_SHORT).show()
                } else {
                    musicViewModel.addMusic(ArtistAlbum(name = artisName, Album = album, ImageAlbum = imageMusic))
                    Toast.makeText(activity, "Added new music", Toast.LENGTH_SHORT).show()
                    activity?.onBackPressed()
                }
            }
        }

    }


}