package com.example.android_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1,edit2,edit3;
    Button btnTong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1 = findViewById(R.id.editTextText);
        edit2 = findViewById(R.id.editTextText2);
        edit3 = findViewById(R.id.editTextText3);

        btnTong = findViewById(R.id.button);
        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1 = edit1.getText().toString().trim();
                String text2 = edit2.getText().toString().trim();
                try {
                    if(text1.isEmpty()||text2.isEmpty()){
                        throw new IllegalArgumentException("Nhập đầy đủ thông tin");
                    }
                    int a = Integer.parseInt(edit1.getText().toString());
                    int b = Integer.parseInt(edit2.getText().toString());
                    int c = a+b;
                    edit3.setText(String.valueOf(c));
//                    Toast.makeText(MainActivity.this,String.valueOf(a+"+"+b+"="+c),Toast.LENGTH_SHORT).show();
//                    edit1.setText("");
//                    edit2.setText("");
                }catch (NumberFormatException e){
                    Toast.makeText(MainActivity.this,"Lỗi định dạng, vui lòng nhập số",Toast.LENGTH_SHORT).show();
                }catch (IllegalArgumentException e){
                    Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"Lỗi k xác định", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}