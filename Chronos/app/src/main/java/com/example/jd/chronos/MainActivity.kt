package com.example.jd.chronos

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Chronometer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup ViewModel
        val model = ViewModelProviders.of(this).get(MainViewModel::class.java)

        val c:Chronometer = findViewById (R.id.chronometer)

        if(model.startTime.equals(0)){
            val startTime = SystemClock.elapsedRealtime()
            model.startTime = startTime
            chronometer.base = startTime

        }else{
            chronometer.base = model.startTime
        }
        c.start()
    }
}
