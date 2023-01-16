package com.chistia007.cgpadom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebViewClient;

import com.chistia007.cgpadom.databinding.ActivityWebsiteBinding;

public class WebsiteActivity extends AppCompatActivity {
    ActivityWebsiteBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityWebsiteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.webView.loadUrl("https://www.facebook.com/profile.php?id=100009298366151");
        binding.webView.setWebViewClient(new WebViewClient()); //to open My FACEBOOK PAGE WITHIN THE APPLICATION
    }
}