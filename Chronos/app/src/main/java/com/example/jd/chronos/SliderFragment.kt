package com.example.jd.chronos

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar

import kotlinx.android.synthetic.main.fragment_slider.*

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [SliderFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [SliderFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SliderFragment : Fragment() {

    private var seekBar: SeekBar? = null


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        seekBar = seekBarX

        subscribeSeekBar()
        return inflater!!.inflate(R.layout.fragment_slider, container, false)
    }



    private fun subscribeSeekBar(){
        seekBar?.setOnSeekBarChangeListener( object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, progress:Int, fromUser:Boolean ){
                Log.d("Slider Fragment:","onProgressChanged")
            }
            override fun onStartTrackingTouch(seekBar: SeekBar){}

            override fun onStopTrackingTouch(seekBar: SeekBar){}
        })
    }





}// Required empty public constructor
