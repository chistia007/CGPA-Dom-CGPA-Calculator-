package com.chistia007.cgpadom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.chistia007.cgpadom.databinding.ActivityCalculateCgpaBinding;

public class CalculateCgpaActivity extends AppCompatActivity {
    ActivityCalculateCgpaBinding binding;
    private Float currentCreditInt;
    private Float currentCgpaInt;
    private String credit1;
    private String credit2;
    private String credit3;
    private String credit4;
    private String credit5;
    private String cgpa1;
    private String cgpa2;
    private String cgpa3;
    private String cgpa4;
    private String cgpa5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCalculateCgpaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Toast.makeText(this, "Leave fields empty that are not necessary for you.", Toast.LENGTH_LONG).show();



        binding.btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentCredit=binding.edtCurrentCredit.getText().toString();
                String currentCgpa=binding.edtCurrentCgpa.getText().toString();
                if(currentCredit.equals("")|| currentCgpa.equals("")){
                    currentCredit+="0";
                    currentCgpa+="0";
                }

                credit1=binding.edtCredit1.getText().toString();
                credit2=binding.edtCredit2.getText().toString();
                credit3=binding.edtCredit3.getText().toString();
                credit4=binding.edtCredit4.getText().toString();
                credit5=binding.edtCredit5.getText().toString();

                cgpa1=binding.edtCgpa1.getText().toString();
                cgpa2=binding.edtCgpa2.getText().toString();
                cgpa3=binding.edtCgpa3.getText().toString();
                cgpa4=binding.edtCgpa4.getText().toString();
                cgpa5=binding.edtCgpa5.getText().toString();

                currentCreditInt=Float.parseFloat(currentCredit);
                currentCgpaInt=Float.parseFloat(currentCgpa);
                calculateCgpa();
            }


        });

    }
    private void calculateCgpa() {
        if(credit1.equals("")|| cgpa1.equals("")){
            Toast.makeText(CalculateCgpaActivity.this, "You can not leave first field of the Taken Courses empty", Toast.LENGTH_SHORT).show();
        }
        else{
            if(credit2.equals("")|| cgpa2.equals("")){
                credit2 +="0";
                cgpa2 +="0";
            }
            if(credit3.equals("")|| cgpa3.equals("")){
                credit3 +="0";
                cgpa3 +="0";
            }
            if(credit4.equals("")|| cgpa4.equals("")){
                credit4 +="0";
                cgpa4 +="0";
            }
            if(credit5.equals("")|| cgpa5.equals("")){
                credit5 +="0";
                cgpa5 +="0";
            }

            Float finalCredit1 = Float.parseFloat(credit1);
            Float finalCgpa1 = Float.parseFloat(cgpa1);

            Float finalCredit2 = Float.parseFloat(credit2);
            Float finalCgpa2 = Float.parseFloat(cgpa2);

            Float finalCredit3 = Float.parseFloat(credit3);
            Float finalCgpa3 = Float.parseFloat(cgpa3);

            Float finalCredit4 = Float.parseFloat(credit4);
            Float finalCgpa4 = Float.parseFloat(cgpa4);

            Float finalCredit5 = Float.parseFloat(credit5);
            Float finalCgpa5 = Float.parseFloat(cgpa5);

            float totalCredit = currentCreditInt + finalCredit1 + finalCredit2 + finalCredit3 + finalCredit4 + finalCredit5;
            float totalCgpa = ((currentCreditInt * currentCgpaInt) + (finalCredit1 * finalCgpa1) + (finalCredit2 * finalCgpa2) + (finalCredit3 * finalCgpa3) + (finalCredit4 * finalCgpa4) + (finalCredit5 * finalCgpa5)) / totalCredit;
            String totalCgpaStr = Float.toString(totalCgpa);
            Toast.makeText(CalculateCgpaActivity.this, totalCgpaStr, Toast.LENGTH_SHORT).show();
        }

    }



}