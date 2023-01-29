package com.chistia007.cgpadom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

import com.chistia007.cgpadom.databinding.ActivityShareWebsiteBinding;

public class ShareWebsite extends AppCompatActivity {
    ActivityShareWebsiteBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityShareWebsiteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.webView.setWebViewClient(new WebViewClient());
        binding.webView.loadUrl("https://play.google.com/store/apps/details?id=com.chistia007.cgpadom");


        WebSettings webSettings=binding.webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}