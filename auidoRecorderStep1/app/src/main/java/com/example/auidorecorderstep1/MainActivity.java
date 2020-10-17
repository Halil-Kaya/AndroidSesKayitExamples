package com.example.auidorecorderstep1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioFormat;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;

import com.github.squti.androidwaverecorder.WaveRecorder;

public class MainActivity extends AppCompatActivity {


    Button btnStart;
    Button btnStop;
    Button btnPause;

    WaveRecorder waveRecorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        InitializeWidgets();
        InitializeEvents();


        String filePath = getExternalCacheDir().getAbsolutePath() + "/audioFile.wav";

        waveRecorder = new WaveRecorder(filePath);

        waveRecorder.getWaveConfig().setSampleRate(44100);
        waveRecorder.getWaveConfig().setChannels(AudioFormat.CHANNEL_IN_STEREO);
        waveRecorder.getWaveConfig().setAudioEncoding(AudioFormat.ENCODING_PCM_8BIT);
        waveRecorder.setNoiseSuppressorActive(true);
        System.out.println("file path: " + filePath);



    }

    public void InitializeWidgets(){
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        btnPause = findViewById(R.id.btnPause);
    }


    public void InitializeEvents(){

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                waveRecorder.startRecording();
                System.out.println("start");

            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                System.out.println("pause");

            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                waveRecorder.startRecording();
                System.out.println("stop");

            }
        });

    }



}