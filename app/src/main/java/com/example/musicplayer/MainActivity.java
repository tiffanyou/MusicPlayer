package com.example.musicplayer;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button playButton;
    private Button pauseButton;
    private Button volUpButton;
    private Button volDownButton;
    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playButton = (Button) findViewById(R.id.play);
        pauseButton = (Button) findViewById(R.id.pause);
        volUpButton = (Button) findViewById(R.id.up);
        volDownButton = (Button) findViewById(R.id.down);
        mediaPlayer = MediaPlayer.create(this, R.raw.ghibli);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        pauseButton.setEnabled(false);
        volUpButton.setEnabled(false);
        volDownButton.setEnabled(false);

        //handle Play button click behaviour
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                pauseButton.setEnabled(true);
                volUpButton.setEnabled(true);
                volDownButton.setEnabled(true);
                playButton.setEnabled(false);
            }
        });

        //handle Pause button click behaviour
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
                playButton.setEnabled(true);
                pauseButton.setEnabled(false);
                volUpButton.setEnabled(false);
                volDownButton.setEnabled(false);
            }
        });

        //handle volume-up button click behaviour
        volUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,
                        AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
            }
        });

        //handle volume-down button click behaviour
        volDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,
                        AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
            }
        });
    }
}
