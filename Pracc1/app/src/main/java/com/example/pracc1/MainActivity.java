package com.example.pracc1;

import static com.example.pracc1.R.*;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button btnopen;
    private TextView tv1, tv2;
    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    private final ActivityResultLauncher<Intent> startForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    Intent data = result.getData();
                    if (data != null) {
                        String name = data.getStringExtra("name");
                        double gpa = data.getDoubleExtra("gpa", 0.0);
                        String displayText = "Họ và tên: " + name + "\nĐiểm GPA: " + gpa;
                        tv1.setText(displayText);
                    }
                }
            });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnopen = findViewById(R.id.btnStart);
        tv1 = findViewById(R.id.tv);

        btnopen.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startForResult.launch(intent);
        });
    }

    }
