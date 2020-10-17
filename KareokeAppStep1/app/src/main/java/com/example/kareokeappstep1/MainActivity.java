package com.example.kareokeappstep1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.kareokeappstep1.audioMixer.AudioMixer;
import com.example.kareokeappstep1.audioMixer.input.AudioInput;
import com.example.kareokeappstep1.audioMixer.input.GeneralAudioInput;

import java.io.FileDescriptor;

public class MainActivity extends AppCompatActivity {

    public Button btnRecord;
    public Button btnPlay;
    public Button btnAzalt;
    public Button btnArttir;
    public Button btnDegisik;
    public Button btnBitir;
    public float volume = 0.5f;
    public MediaPlayer mediaPlayer = new MediaPlayer();
    public MediaRecorder mediaRecorder = new MediaRecorder();
    public java.io.File baseRecordPath;
    public ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] dizi = {android.Manifest.permission.RECORD_AUDIO,android.Manifest.permission.WRITE_EXTERNAL_STORAGE,android.Manifest.permission.READ_EXTERNAL_STORAGE};


        btnRecord = findViewById(R.id.btnRecord);
        btnPlay = findViewById(R.id.btnPlay);
        btnArttir = findViewById(R.id.btnArttir);
        btnAzalt = findViewById(R.id.btnAzalt);
        btnDegisik = findViewById(R.id.btnDegisik);
        btnBitir = findViewById(R.id.btnBitir);
        progressBar = findViewById(R.id.progressBar);


        progresbarGizle();


        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.RECORD_AUDIO)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    dizi,
                    1234);
        }


        btnArttir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volume = volume + 0.1f;
                mediaPlayer.setVolume(volume,volume);
            }
        });

        btnAzalt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volume = volume - 0.1f;
                mediaPlayer.setVolume(volume,volume);

            }
        });

        btnDegisik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volume = volume - 0.1f;
                mediaPlayer.setVolume(0.9f,0.1f);
            }
        });

        btnRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println("record");
                arkaPlanMuziginiBaslat();
                sesKaydiniBaslat();



            }
        });

        btnBitir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaRecorder.stop();
                mediaRecorder.release();
                startMixing();
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{

                    java.io.File recordPath = new java.io.File(Environment.getExternalStorageDirectory(), "/Music/oldu.mp3");
                    String outputPath = recordPath.getAbsolutePath();

                    mediaPlayer.setDataSource(outputPath);
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                    ekranaToastBastir("caliyor");
                    ekranaToastBastir("süre: " + mediaPlayer.getDuration());


                }catch (Exception e){

                }

            }
        });


    }

    private void startMixing() {
        progresbarGoster();
        java.io.File recordPath = new java.io.File(Environment.getExternalStorageDirectory(), "/Music/oldu.mp3");
        String outputPath = recordPath.getAbsolutePath();

        AudioMixer audioMixer = null;
        try {
            audioMixer = new AudioMixer(outputPath);
            ekranaToastBastir("1");

            AudioInput audioInput;
            GeneralAudioInput kisininSesi = new GeneralAudioInput(baseRecordPath.getAbsolutePath());
            ekranaToastBastir("2");

            GeneralAudioInput arkaPlanMuzigi = new GeneralAudioInput(baseRecordPath.getAbsolutePath());
            ekranaToastBastir("3");

            arkaPlanMuzigi.setVolume(volume);
            ekranaToastBastir("4");

            audioMixer.addDataSource(kisininSesi);
            ekranaToastBastir("5");

            audioMixer.addDataSource(arkaPlanMuzigi);
            ekranaToastBastir("6");

        } catch (Exception e) {
            ekranaToastBastir("hata oldu sebebi: " + e.getMessage());
            e.printStackTrace();
        }

        //audioMixer.setSampleRate(44100);  // optional
        //audioMixer.setBitRate(128000); // optional
        //audioMixer.setChannelCount(2); // 1 or 2 // optional
        //audioMixer.setLoopingEnabled(true); // Only works for parallel mixing
        audioMixer.setMixingType(AudioMixer.MixingType.PARALLEL);
        audioMixer.setProcessingListener(new AudioMixer.ProcessingListener() {
            @Override
            public void onProgress(double progress) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        ekranaToastBastir("kaydediyor");
                    }
                });
            }

            @Override
            public void onEnd() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progresbarGizle();
                        ekranaToastBastir("kaydetti");
                    }
                });
            }
        });
    }


    public void progresbarGoster(){
        progressBar.setVisibility(View.VISIBLE);
    }
    public void progresbarGizle(){
        progressBar.setVisibility(View.INVISIBLE);


    }

        public void sesKaydiniBaslat(){


        baseRecordPath = new java.io.File(Environment.getExternalStorageDirectory(), "/Music/tmp.mp3");


        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        mediaRecorder.setOutputFile(baseRecordPath.getAbsolutePath());

        try{
            mediaRecorder.prepare();
            mediaRecorder.start();
            ekranaToastBastir("ses kaydetmeye basladi");
        }catch (Exception e){

        }


    }

    public void arkaPlanMuziginiBaslat(){

        try{


            mediaPlayer.setDataSource("https://akustikaraoke.com/uploads/arguman-beat-sen-seversin-melankolik-beat-keman.mp3");
            mediaPlayer.prepare();
            mediaPlayer.start();
            ekranaToastBastir("caliyor");
            ekranaToastBastir("süre: " + mediaPlayer.getDuration());


        }catch (Exception e){

        }
    }

    public void ekranaToastBastir(String yazi){
        Toast.makeText(getApplicationContext(),yazi,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


        if(requestCode == 1234){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {


                Toast.makeText(this,"izin var", Toast.LENGTH_SHORT).show();


            }

        }

    }
}