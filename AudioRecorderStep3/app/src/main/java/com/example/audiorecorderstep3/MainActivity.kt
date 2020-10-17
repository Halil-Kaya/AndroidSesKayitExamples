package com.example.audiorecorderstep3

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.github.windsekirun.naraeaudiorecorder.NaraeAudioRecorder
import com.github.windsekirun.naraeaudiorecorder.config.AudioRecordConfig
import com.github.windsekirun.naraeaudiorecorder.source.NoiseAudioSource
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dizi = arrayOf(android.Manifest.permission.RECORD_AUDIO,android.Manifest.permission.WRITE_EXTERNAL_STORAGE,android.Manifest.permission.READ_EXTERNAL_STORAGE)

        if (ContextCompat.checkSelfPermission(this,
                        android.Manifest.permission.RECORD_AUDIO)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    dizi,
                    1234);
        }


        val audioRecorder = NaraeAudioRecorder()
        val destFile = File(File(Environment.getExternalStorageDirectory(), "/Music/firsdtauidio.mp3"))

        val recordConfig = AudioRecordConfig.defaultConfig()
        val audioSource = NoiseAudioSource(recordConfig)
        audioRecorder.create() {
            this.destFile = destFile
            this.recordConfig = recordConfig
            this.audioSource = audioSource
        }


        btnStart.setOnClickListener {
            Toast.makeText(this,"basladi", Toast.LENGTH_SHORT).show()
            audioRecorder.startRecording(this)
        }

        btnStop.setOnClickListener {
            Toast.makeText(this,"bitti", Toast.LENGTH_SHORT).show()
            audioRecorder.stopRecording()
        }


    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)


        if(requestCode == 1234){
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {


                Toast.makeText(this,"izin var", Toast.LENGTH_SHORT).show()


            }

        }

    }
}