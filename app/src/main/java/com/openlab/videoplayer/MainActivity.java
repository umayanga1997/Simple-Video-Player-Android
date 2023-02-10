package com.openlab.videoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView _videoView;
    TextView _status_txt;
    Button _playBtn;
    Button _pauseBtn;
    Button _resumeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init Components
        _videoView = (VideoView) findViewById(R.id.video_player);
        _status_txt = findViewById(R.id.status_txt);
        _playBtn =  findViewById(R.id.play_btn);
        _pauseBtn = findViewById(R.id.pause_btn);
        _resumeBtn = findViewById(R.id.resume_btn);

        // Config file path
        String fileRawPath = "android.resource://"+ getPackageName()+"/"+ R.raw.test;

        // Set video URL
        _videoView.setVideoURI(Uri.parse(fileRawPath));

        // Get File Name
        String[] names = getResources().getResourceName(R.raw.test).split("/");
        String fileName = names[names.length - 1];

        // Init data to Status Text
        _status_txt.setText("Waiting for your command...");

        // Set events
        _playBtn.setOnClickListener(v -> {
            if(_videoView != null) {
                _videoView.start();
                _status_txt.setText(fileName + " video is playing");
            }
        });

        _pauseBtn.setOnClickListener(v -> {
            _videoView.pause();
            _status_txt.setText(fileName + " video was paused");
        });

        _resumeBtn.setOnClickListener(v -> {
            _videoView.resume();
//            _videoView.setVideoURI(Uri.parse(fileRawPath));
            _status_txt.setText(fileName + " video was resumed");
        });


    }
}