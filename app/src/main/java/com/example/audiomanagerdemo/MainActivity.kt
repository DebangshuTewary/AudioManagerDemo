package com.example.audiomanagerdemo

import android.app.NotificationManager
import android.content.Intent
import android.media.AudioManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nm = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M && !nm.isNotificationPolicyAccessGranted)
        {
            startActivity(Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS))
        }

        val am = getSystemService(AUDIO_SERVICE) as AudioManager
        val but1=findViewById<Button>(R.id.button)
        val but2=findViewById<Button>(R.id.button2)
        val but3=findViewById<Button>(R.id.button3)
        val but4=findViewById<Button>(R.id.button4)
        but1.setOnClickListener {
            am.ringerMode = AudioManager.RINGER_MODE_NORMAL
            Toast.makeText(applicationContext,"Ringer Mode Set" ,Toast.LENGTH_SHORT).show()
        }
        but2.setOnClickListener {
            am.ringerMode = AudioManager.RINGER_MODE_VIBRATE
            Toast.makeText(applicationContext,"Vibrate Mode Set" ,Toast.LENGTH_SHORT).show()
        }
        but3.setOnClickListener {
            am.ringerMode = AudioManager.RINGER_MODE_NORMAL
            am.ringerMode = AudioManager.RINGER_MODE_SILENT
            Toast.makeText(applicationContext,"Silent Mode Set" ,Toast.LENGTH_SHORT).show()
        }
        but4.setOnClickListener {
            when(am.ringerMode)
            {
                AudioManager.RINGER_MODE_NORMAL -> Toast.makeText(applicationContext,"Current Mode is Ringing" ,Toast.LENGTH_SHORT).show()
                AudioManager.RINGER_MODE_VIBRATE -> Toast.makeText(applicationContext,"Current Mode is Vibrate" ,Toast.LENGTH_SHORT).show()
                AudioManager.RINGER_MODE_SILENT-> Toast.makeText(applicationContext,"Current Mode is Silent" ,Toast.LENGTH_SHORT).show()
            }

        }
    }
}