package com.example.pracc3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pracc3.model.Country;

public class CountryDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);
        Intent intent = getIntent();
        Country country = (Country) intent.getSerializableExtra("country");


        ImageView imgFlag = findViewById(R.id.imgFlag);
        TextView txtName = findViewById(R.id.txtName);
        TextView txtCapital = findViewById(R.id.txtCapital);
        TextView txtPopulation = findViewById(R.id.txtPopulation);
        TextView txtArea = findViewById(R.id.txtArea);
        TextView txtDestiny = findViewById(R.id.txtDestiny);
        TextView txtWorldShare = findViewById(R.id.txtWorldShare);
        Button btnBack = findViewById(R.id.btnBack);


        if (country != null) {
            imgFlag.setImageResource(country.getFlag());
            txtName.setText(country.getNation());
            txtCapital.setText(country.getCapital());
            txtPopulation.setText(country.getPopulation());
            txtArea.setText(country.getArea());
            txtDestiny.setText(country.getDestiny());
            txtWorldShare.setText(country.getWorldShare());
        } else {

            txtName.setText("Thông tin không có sẵn");
            txtCapital.setText("");
            txtPopulation.setText("");
            txtArea.setText("");
            txtDestiny.setText("");
            txtWorldShare.setText("");
            imgFlag.setImageResource(R.drawable.ic_launcher_foreground); 
        }


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}