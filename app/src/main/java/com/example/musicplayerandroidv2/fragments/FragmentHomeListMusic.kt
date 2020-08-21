package com.example.musicplayerandroidv2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicplayerandroidv2.R
import com.example.musicplayerandroidv2.recycleviewadapter.MusicViewAdapter
import com.example.musicplayerandroidv2.viewmodelmusic.ViewModelMusic
import kotlinx.android.synthetic.main.fragment_home_list_music.*

class FragmentHomeListMusic : Fragment(), View.OnClickListener {
    val viewModelMusic by activityViewModels<ViewModelMusic>()
    lateinit var musicViewRecycleAdapter: MusicViewAdapter
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_list_music, container, false)
    }

    override fun onClick(v: View?) {
       when(v){
           addNewMusicButton->{
                navController.navigate(R.id.action_fragmentHomeListMusic_to_fragmentAddMusic)
           }
       }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        musicListRecycleView.layoutManager=LinearLayoutManager(activity)
        //musicViewRecycleAdapter= MusicViewAdapter(viewModelMusic.musicLiveData.value!!)
        //musicListRecycleView.adapter=musicViewRecycleAdapter
        viewModelMusic.getAllAlbum().observe(viewLifecycleOwner, Observer {
            musicViewRecycleAdapter= MusicViewAdapter(it)
           // musicViewRecycleAdapter.notifyDataSetChanged()
            musicListRecycleView.adapter=musicViewRecycleAdapter
        })
        addNewMusicButton.setOnClickListener(this)
        navController=Navigation.findNavController(view)


    }
}