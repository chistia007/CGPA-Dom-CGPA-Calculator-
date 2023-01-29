package com.chistia007.cgpadom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebViewClient;

import com.chistia007.cgpadom.databinding.ActivityLinkdinWebsiteBinding;

public class LinkdinWebsiteActivity extends AppCompatActivity {
    ActivityLinkdinWebsiteBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityLinkdinWebsiteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.webView.loadUrl("https://www.linkedin.com/in/chisthia-khan-b94112263?lipi=urn%3Ali%3Apage%3Ad_flagship3_profile_view_base_contact_details%3BiG6tjLMvTreOYdhpCF53NA%3D%3D");
        binding.webView.setWebViewClient(new WebViewClient());
    }
}