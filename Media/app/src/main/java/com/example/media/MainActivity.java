package com.example.media;

import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

        private VideoView vv_video;
        /*
        使用VideoView+MediaController实现视频播放器
         */
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            vv_video = (VideoView) findViewById(R.id.vv_video); ////获取VideoView的id
            //设置播放的来源
            Log.d("path", String.valueOf(Environment.getExternalStorageDirectory()));
            vv_video.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.test);
//            vv_video.setVideoURI(Uri.parse("file:///sdcard/Movies/test.mp4"));
            //实例化媒体控制器
            MediaController mediaController=new MediaController(this);
            mediaController.setMediaPlayer(vv_video);
            vv_video.setMediaController(mediaController);
            vv_video.start();
        }
}