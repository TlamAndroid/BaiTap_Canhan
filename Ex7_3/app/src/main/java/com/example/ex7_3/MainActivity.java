package com.example.ex7_3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

public class MainActivity extends AppCompatActivity {

    EditText editTextA, editTextB, editTextResult;
    private Button btnRequest;
    private ActivityResultLauncher<Intent> resultLauncher;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editTextA = findViewById(R.id.editA);
        editTextB = findViewById(R.id.editB);
        editTextResult = findViewById(R.id.editTR);
        btnRequest = findViewById(R.id.btnRQ);
        resultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == 33 && result.getData() != null) {
                        int sum = result.getData().getIntExtra("kq", 0);
                        editTextResult.setText(String.valueOf(sum));
                    } else if (result.getResultCode() == 34 && result.getData() != null) {
                        int sub = result.getData().getIntExtra("kq", 0);
                        editTextResult.setText(String.valueOf(sub));
                    }
                });

        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, Result.class);
                int a = Integer.parseInt(editTextA.getText().toString());
                int b = Integer.parseInt(editTextB.getText().toString());
                myIntent.putExtra("soa", a);
                myIntent.putExtra("sob", b);
                resultLauncher.launch(myIntent);
            }
        });
    }
}