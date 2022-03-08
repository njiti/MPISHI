package com.example.mpishi.Tutorials;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mpishi.R;

public class ShortActivity extends AppCompatActivity {

    //Video URL
    String videoUrl = "https://player.vimeo.com/external/561101633.sd.mp4?s=2835e8537a68ec7658a18a0d32362a05ae914130&profile_id=165&oauth2_token_id=57447761";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short);

        // finding videoView by its id
        VideoView videoView = (VideoView) findViewById(R.id.videoView);

        // Uri object to refer the
        // resource from the videoUrl
        Uri uri = Uri.parse(videoUrl);

        // sets the resource from the
        // videoUrl to the videoView
        videoView.setVideoURI(uri);

        // create an object of media controller
        MediaController mediaController = new MediaController(this);
// initiate a video view
// set media controller object for a video view
        videoView.setMediaController(mediaController);
        videoView.start(); // start a video
    }
}