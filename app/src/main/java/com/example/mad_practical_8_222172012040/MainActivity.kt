package com.example.mad_practical_8_22172012028

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mad_practical_8_222172012040.AlarmBreoadcastReceiver
import com.example.mad_practical_8_222172012040.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun setalarm(militime:Long,action:String)
    {
        val intentalarm=Intent(applicationContext, AlarmBreoadcastReceiver::class.java)
        intentalarm.putExtra(AlarmBreoadcastReceiver.ALARMKEY,action)
        val pendingintent=PendingIntent.getBroadcast(applicationContext,4345,intentalarm,PendingIntent.FLAG_UPDATE_CURRENT)
        val manager =getSystemService(ALARM_SERVICE) as AlarmManager
        if(action==AlarmBreoadcastReceiver.ALARMSTART)
        {
            manager.setExact(AlarmManager.RTC_WAKEUP,militime,pendingintent)
        }
        else
        {
            manager.cancel(pendingintent)
            sendBroadcast(intentalarm)
        }
    }
}