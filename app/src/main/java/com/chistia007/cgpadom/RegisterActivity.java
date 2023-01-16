package com.chistia007.cgpadom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chistia007.cgpadom.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {
    ActivityRegisterBinding binding;
    private FirebaseAuth mAuth;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //mRootRef= FirebaseDatabase.getInstance().getReference();
        mAuth= FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);

        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtName=binding.edtName.getText().toString();
                String txtEmail=binding.edtEmail.getText().toString();
                String txtPassword=binding.edtPassword.getText().toString();
                if(TextUtils.isEmpty(txtName)|| TextUtils.isEmpty(txtEmail)|| TextUtils.isEmpty(txtPassword)){
                    Toast.makeText(RegisterActivity.this, "Empty credentials", Toast.LENGTH_SHORT).show();
                }
                else if(txtPassword.length()<6){
                    Toast.makeText(RegisterActivity.this, "Password too short", Toast.LENGTH_SHORT).show();
                }
                else{
                    registerUser(txtName,txtEmail,txtPassword);
                }
            }

            private void registerUser(String name, String email, String password) {
                progressDialog.setTitle("Please wait...");
                progressDialog.show();
                mAuth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(RegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                        FirebaseFirestore db = FirebaseFirestore.getInstance();
                        Map<String,String> user=new HashMap<>();
                        user.put("name",binding.edtName.getText().toString());
                        user.put("email",binding.edtEmail.getText().toString());
                        user.put("password",binding.edtPassword.getText().toString());
                        user.put("credit","0");
                        user.put("cgpa","0");

                        CollectionReference col = db.collection("Users");

                        col.document(Objects.requireNonNull(mAuth.getCurrentUser()).getUid()).set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(RegisterActivity.this, "document successfully stored", Toast.LENGTH_SHORT).show();
                            }
                        })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                        progressDialog.dismiss();
                        startActivity(new Intent(RegisterActivity.this,CgpaBracuCalculatorActivity.class));

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}