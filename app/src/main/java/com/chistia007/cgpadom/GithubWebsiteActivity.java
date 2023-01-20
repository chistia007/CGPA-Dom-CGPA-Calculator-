package com.chistia007.cgpadom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebViewClient;

import com.chistia007.cgpadom.databinding.ActivityGithubWebsiteBinding;

public class GithubWebsiteActivity extends AppCompatActivity {
    ActivityGithubWebsiteBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityGithubWebsiteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.webView.loadUrl("https://github.com/chistia007");
        binding.webView.setWebViewClient(new WebViewClient());
    }
}