package com.example.jd.chronos

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
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
    private var seekBarViewModel:SliderViewModel? = null


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        ///seekBar = seekBarX
        val root = inflater?.inflate(R.layout.fragment_slider, container, false)
        Log.d("Slider Fragment:","onCreateVirew")
        seekBar = root?.findViewById(R.id.seekBarX);

        seekBarViewModel = ViewModelProviders.of( activity ).get(SliderViewModel::class.java)
        subscribeSeekBar()
        return root
    }



    private fun subscribeSeekBar(){
        Log.d("Slider Fragment:",seekBar.toString())
        seekBar?.setOnSeekBarChangeListener( object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, progress:Int, fromUser:Boolean ){
                if(fromUser){
                    Log.d("Slider Fragment:","onProgressChanged")
                    seekBarViewModel?.sliderBarValue?.value = progress
                }
            }
            override fun onStartTrackingTouch(seekBar: SeekBar){}

            override fun onStopTrackingTouch(seekBar: SeekBar){}
        })



        // Update the SeekBar when the ViewModel is changed.
        seekBarViewModel?.sliderBarValue?.observe(activity, Observer<Int> { value ->
            if (value != null) {
                seekBar?.progress = value
            }
        })
    }





}// Required empty public constructor
