package com.chistia007.cgpadom;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

import com.chistia007.cgpadom.databinding.ActivityWebsiteBinding;

public class WebsiteActivity extends AppCompatActivity {
    ActivityWebsiteBinding binding;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityWebsiteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.webView.setWebViewClient(new WebViewClient());
        binding.webView.loadUrl("https://chistia007.github.io/");


        WebSettings webSettings=binding.webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}