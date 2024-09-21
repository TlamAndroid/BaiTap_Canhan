package com.example.karma_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextInputEditText edit1,edit2;
        CheckBox cb;
        Button bt;
        TextView txt_signup;
        edit1=findViewById(R.id.ed1);
        edit2=findViewById(R.id.ed2);
        cb = findViewById(R.id.checkBox);
        bt=findViewById(R.id.button);
        txt_signup = findViewById(R.id.textView3);
        SpannableString txtspanner = new SpannableString(txt_signup.getText());
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Toast.makeText(MainActivity.this,"Đã click thành công", Toast.LENGTH_SHORT).show();
            }
//            @Override
//            public void updateDrawState(TextPaint dr){
//                super.updateDrawState(dr);
////                dr.setColor(Color.BLUE);
//            }
        };
        txtspanner.setSpan(clickableSpan,26,33, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        txt_signup.setText(txtspanner);
        txt_signup.setMovementMethod(LinkMovementMethod.getInstance());


    }
}