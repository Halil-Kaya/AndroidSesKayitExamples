package com.example.audiorecorderstep4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SingActivity extends AppCompatActivity {

    public static final String EXTRA_SONG = "EXTRA_SONG";
    @SuppressWarnings("SpellCheckingInspection")
    private KaraokeController mKaraokeKonroller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing);
        mKaraokeKonroller = new KaraokeController();
        mKaraokeKonroller.init(findViewById(R.id.root), R.id.lyrics, R.id.tone_render);
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, 1);
        else {
            tryLoadSong();
        }
    }

    private void tryLoadSong() {
        String songFile = getIntent().getStringExtra(EXTRA_SONG);
        if(null != songFile)
            mKaraokeKonroller.load(new File(songFile));
        else
            finish();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED)
            finish();
        else
            tryLoadSong();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mKaraokeKonroller.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mKaraokeKonroller.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mKaraokeKonroller.onStop();
    }
}