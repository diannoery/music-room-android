package com.example.musicplayerandroidv2.recycleviewadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayerandroidv2.R
import com.example.musicplayerandroidv2.room.SongAlbum

class ListMusicAlbum(private val listSong: List<SongAlbum>) :
    RecyclerView.Adapter<SongViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_music_album_layout, parent, false)
        return SongViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.songTitle.text = listSong[position].songName
        holder.songDuration.text = listSong[position].songDuration
        holder.imageView.setOnClickListener {
            holder.imageView.setImageResource(R.drawable.ic_baseline_pause_24)
        }
    }

    override fun getItemCount(): Int {
        return listSong.size
    }

}

class SongViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val songTitle = view.findViewById<TextView>(R.id.judulLagu)
    val songDuration = view.findViewById<TextView>(R.id.minute)
    val imageView = view.findViewById<ImageView>(R.id.play)
}
