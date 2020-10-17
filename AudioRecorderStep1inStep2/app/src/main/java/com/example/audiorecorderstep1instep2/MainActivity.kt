package com.example.audiorecorderstep1instep2

import android.content.pm.PackageManager
import android.media.AudioFormat
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.github.squti.androidwaverecorder.WaveRecorder
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.util.*
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var dizi = arrayOf(android.Manifest.permission.RECORD_AUDIO,android.Manifest.permission.WRITE_EXTERNAL_STORAGE,android.Manifest.permission.READ_EXTERNAL_STORAGE)

        if (ContextCompat.checkSelfPermission(this,
                        android.Manifest.permission.RECORD_AUDIO)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    dizi,
                    1234);
        }

        var guid = UUID.randomUUID().toString();
        var file = File(Environment.getExternalStorageDirectory(), "/Music/"+guid+".mp3")
        //val filePath:String = externalCacheDir?.absolutePath + "/Music/audioFile.wav"
        var filePath:String = file.absolutePath



        var waveRecorder = WaveRecorder(filePath )
        waveRecorder.waveConfig.sampleRate = 16000
        waveRecorder.waveConfig.channels = AudioFormat.CHANNEL_IN_MONO
        waveRecorder.waveConfig.audioEncoding = AudioFormat.ENCODING_PCM_16BIT
        waveRecorder.noiseSuppressorActive = true






        btnStart.setOnClickListener {

            var guid = UUID.randomUUID().toString();
            var file = File(Environment.getExternalStorageDirectory(), "/Music/"+guid+".mp3")
            //val filePath:String = externalCacheDir?.absolutePath + "/Music/audioFile.wav"
            var filePath:String = file.absolutePath



            //val filePath:String = externalCacheDir?.absolutePath + "/Music/audioFile.wav"
            waveRecorder = WaveRecorder(filePath )
            waveRecorder.waveConfig.sampleRate = 16000
            waveRecorder.waveConfig.channels = AudioFormat.CHANNEL_IN_MONO
            waveRecorder.waveConfig.audioEncoding = AudioFormat.ENCODING_PCM_16BIT
            waveRecorder.noiseSuppressorActive = true


            Toast.makeText(this,"basladi",Toast.LENGTH_SHORT).show()
            waveRecorder.startRecording()


        }

        btnPause.setOnClickListener {

            waveRecorder.pauseRecording()
            Toast.makeText(this,"durdu",Toast.LENGTH_SHORT).show()

        }

        btnStop.setOnClickListener {
            waveRecorder.stopRecording()
            Toast.makeText(this,"bitti",Toast.LENGTH_SHORT).show()

        }



    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)


        if(requestCode == 1234){
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {


                Toast.makeText(this,"izin var",Toast.LENGTH_SHORT).show()


            }

        }

    }

}