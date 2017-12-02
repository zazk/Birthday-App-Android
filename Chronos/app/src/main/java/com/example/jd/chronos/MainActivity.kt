package com.example.jd.chronos

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.Chronometer
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    var model:MainViewModel = MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup ViewModel
        model = ViewModelProviders.of(this).get(MainViewModel::class.java)

        val c:Chronometer = findViewById (R.id.chronometer)

        if(model.startTime.equals(0)){
            val startTime = SystemClock.elapsedRealtime()
            model.startTime = startTime
            chronometer.base = startTime

        }else{
            chronometer.base = model.startTime
        }
        c.start()
        subscribe()
    }

    private fun subscribe() {
        val elapsedTimeObserver = Observer<Long> { aLong ->
            val newText:String = this.resources.getString(R.string.seconds,aLong)
            timer_textview.text = newText
            Log.d("Chrono Activity", "Updating timer")
        }

        model.mTimer.observe(this, elapsedTimeObserver)
    }
}
