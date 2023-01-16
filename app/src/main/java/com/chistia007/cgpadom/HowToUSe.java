package com.chistia007.cgpadom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.chistia007.cgpadom.databinding.ActivityHowToUseBinding;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class HowToUSe extends AppCompatActivity {
    ActivityHowToUseBinding binding;
    private YouTubePlayerView youtubePlayerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHowToUseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}