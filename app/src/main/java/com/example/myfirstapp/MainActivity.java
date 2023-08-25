package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtTXT;
        EditText edtHeightFt, edtHeightIn,edtWeight;
        Button btnCalc;
        LinearLayout llMain;
        edtWeight=findViewById(R.id.edtWeight);
        edtHeightIn=findViewById(R.id.edtHeightIn);
        edtHeightFt=findViewById(R.id.edtHeightFt);
        btnCalc=findViewById(R.id.btnCalc);
        txtTXT=findViewById(R.id.textTXT);
        llMain=findViewById(R.id.llMain);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt =Integer.parseInt(edtWeight.getText().toString());
                int hFt =Integer.parseInt(edtHeightFt.getText().toString());
                int hIn =Integer.parseInt(edtHeightIn.getText().toString());

                int totalIn= hFt*12+ hIn;
                double totalCm= totalIn*2.53;
                double totalM = totalCm/100;
                double bmi = wt/Math.pow(totalM,2);
                if(bmi>25){
                    txtTXT.setText("You are Overwieght");
                    llMain.setBackgroundColor(getResources().getColor(R.color.Over));
                }
                else if(bmi<18){
                    txtTXT.setText("You are underweight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.Under));
                }
                else{
                    txtTXT.setText("You are Healthy");
                    llMain.setBackgroundColor(getResources().getColor(R.color.Healthy));
                }
            }
        });

    }
}