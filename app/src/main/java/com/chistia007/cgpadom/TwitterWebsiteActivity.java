package com.chistia007.cgpadom;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

import com.chistia007.cgpadom.databinding.ActivityTwitterWebsiteBinding;

public class TwitterWebsiteActivity extends AppCompatActivity {
    ActivityTwitterWebsiteBinding binding;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityTwitterWebsiteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.webView.setWebViewClient(new WebViewClient());
        binding.webView.loadUrl("https://twitter.com/chisthia_khan");

        WebSettings webSettings=binding.webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}