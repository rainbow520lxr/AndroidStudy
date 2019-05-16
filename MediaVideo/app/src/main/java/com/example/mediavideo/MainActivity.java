package com.example.mediavideo;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;
import java.io.File;

public class MainActivity extends AppCompatActivity {

    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        video = findViewById(R.id.video);
        File file = new File("/storage/self/primary/Movies/test.mp4");
        Log.d("path", file.getAbsolutePath());
        video.setVideoPath(Environment.getExternalStorageDirectory()+"/Movies/test");
        MediaController mc = new MediaController(this);
        mc.setMediaPlayer(video);
        video.setMediaController(mc);
    }
}
