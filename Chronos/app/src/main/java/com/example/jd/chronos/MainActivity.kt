package com.example.jd.chronos

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val c:Chronometer = findViewById (R.id.chronometer)
        c.start()
    }
}
