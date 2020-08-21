package com.example.musicplayerandroidv2.recycleviewadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.example.musicplayerandroidv2.R
import com.example.musicplayerandroidv2.room.ArtistAlbum
import kotlinx.android.synthetic.main.item_list_music_layout.view.*


class MusicViewAdapter(private val musicList: List<ArtistAlbum>) :
    RecyclerView.Adapter<MusicViewHolder>() {
    lateinit var navController: NavController
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_music_layout, parent, false)
        return MusicViewHolder(view)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val album = musicList[position].Album
        val artist = musicList[position].name
        val image = musicList[position].ImageAlbum

        holder.album.text = album
        holder.artist.text = artist
        holder.images.load("$image")
        val bundle = bundleOf(Pair("albumId", musicList[position].id))
        holder.itemView.musicClick.setOnClickListener {
            navController = Navigation.findNavController(it)
            navController.navigate(
                R.id.action_fragmentHomeListMusic_to_fragmentDetailMusic,
               bundle
            )

        }


    }

    override fun getItemCount(): Int {
        return musicList.size
    }
}


class MusicViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val album = v.findViewById<TextView>(R.id.musicTitle)
    val artist = v.findViewById<TextView>(R.id.musicArtistName)
    val images = v.findViewById<ImageView>(R.id.musicImage)

}