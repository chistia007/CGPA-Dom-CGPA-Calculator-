package com.chistia007.cgpadom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.chistia007.cgpadom.databinding.ActivityLearnAppDevBinding;

public class LearnAppDev extends AppCompatActivity {
    ActivityLearnAppDevBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLearnAppDevBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LearnAppDev.this,GithubWebsiteActivity.class));
            }
        });

        binding.btnLinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LearnAppDev.this,LinkdinWebsiteActivity.class));
            }
        });

        binding.btnTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LearnAppDev.this,TwitterWebsiteActivity.class));
            }
        });
    }
}