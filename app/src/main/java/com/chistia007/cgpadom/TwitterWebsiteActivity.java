package com.chistia007.cgpadom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebViewClient;

import com.chistia007.cgpadom.databinding.ActivityTwitterWebsiteBinding;

public class TwitterWebsiteActivity extends AppCompatActivity {
    ActivityTwitterWebsiteBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityTwitterWebsiteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.webView.loadUrl("https://twitter.com/chisthia_khan");
        binding.webView.setWebViewClient(new WebViewClient());
    }
}