package com.chistia007.cgpadom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.chistia007.cgpadom.databinding.ActivityHowToUseBinding;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class HowToUSe extends AppCompatActivity {
    ActivityHowToUseBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHowToUseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}