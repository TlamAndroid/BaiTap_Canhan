package com.example.pracc1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private EditText et1, et2;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second); // Đảm bảo layout này tồn tại

        et1 = findViewById(R.id.edt1);
        et2 = findViewById(R.id.edt2);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> {
            String name = et1.getText().toString();
            double gpa = Double.parseDouble(et2.getText().toString());

            Intent resultIntent = new Intent();
            resultIntent.putExtra("name", name);
            resultIntent.putExtra("gpa", gpa);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}