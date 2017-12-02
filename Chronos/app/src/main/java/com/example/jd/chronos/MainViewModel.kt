package com.example.jd.chronos

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.MutableLiveData
import android.os.SystemClock
import java.util.*
import kotlin.concurrent.timerTask

//import android.arch.lifecycle
/**
 * Created by jd on 11/22/17.
 */
class MainViewModel:ViewModel{

    var startTime:Long
    var elapsedTime:Long = 0
    val ONE_SECOND:Int = 5000
    val mTimer:MutableLiveData<Long> = MutableLiveData()

    constructor(){
        startTime = SystemClock.elapsedRealtime()
        val timer:Timer = Timer()
        timer.scheduleAtFixedRate(timerTask {
            elapsedTime = (SystemClock.elapsedRealtime() - startTime)/1000
            mTimer.postValue(elapsedTime)
        },ONE_SECOND.toLong(),ONE_SECOND.toLong())
    }


}
