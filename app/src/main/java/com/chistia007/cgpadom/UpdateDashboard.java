package com.chistia007.cgpadom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.chistia007.cgpadom.databinding.ActivityUpdateDashboardBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class UpdateDashboard extends AppCompatActivity {
    ActivityUpdateDashboardBinding binding;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityUpdateDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();


        binding.btnUpdateDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.layVisibility1.setVisibility(View.VISIBLE);
                binding.layVisibility2.setVisibility(View.VISIBLE);


                binding.btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String credit=binding.edtCurrentCredit.getText().toString();
                        String cgpa=binding.edtCurrentCgpa.getText().toString();
                        db.collection("Users").document(mAuth.getCurrentUser().getUid())
                                .update(
                                        "cgpa", cgpa,
                                        "credit", credit
                                );
                        Intent intent= new Intent(UpdateDashboard.this, CgpaBracuCalculatorActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });




        binding.btnResetDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.collection("Users").document(mAuth.getCurrentUser().getUid())
                        .update(
                                "cgpa", "0",
                                "credit", "0"
                        );
                Intent intent= new Intent(UpdateDashboard.this, CgpaBracuCalculatorActivity.class);
                startActivity(intent);
            }
        });
    }
}