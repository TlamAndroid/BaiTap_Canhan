package com.example.ex4_2;

import android.annotation.SuppressLint;
import android.icu.text.DecimalFormat;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnChandoan;
    EditText editTen, editChieucao, editCannang, editBMI, editChandoan;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnChandoan = findViewById(R.id.BMICalculateButton);
        editTen = findViewById(R.id.InputNameEditText);
        editChieucao = findViewById(R.id.InputHeightEditText);
        editCannang = findViewById(R.id.InputWeightEditText);
        editBMI = findViewById(R.id.BMIEditText);
        editChandoan = findViewById(R.id.DiagnoseEditText);
        btnChandoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double H = Double.parseDouble(editChieucao.getText() + "") / 100;
                double W = Double.parseDouble(editCannang.getText() + "");
                double BMI = W / Math.pow(H, 2);
                String chandoan = "";
                if (BMI < 18) {
                    chandoan = "Bạn gầy";
                } else if (BMI <= 24.9) {
                    chandoan = "Bạn bình thường";
                } else if (BMI <= 29.9) {
                    chandoan = "Bạn béo phì độ 1";
                } else if (BMI <= 34.9) {
                    chandoan = "Bạn béo phì độ 2";
                } else {
                    chandoan = "Bạn béo phì độ 3";
                }
                DecimalFormat dcf = new DecimalFormat("#.0");
                editBMI.setText(dcf.format(BMI));

                editChandoan.setText(chandoan);
            }
        });
    }
}