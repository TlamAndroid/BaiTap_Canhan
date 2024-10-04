package com.example.pracc3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pracc3.model.Country;
import com.example.pracc3.model.CountryAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Country> countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        countries = new ArrayList<>();
        countries.add(new Country(R.drawable.india, "Ấn Độ", "New Delhi", "1,428.6 triệu", "3,287,263 km²", "481 người/km²", "17,76%"));
        countries.add(new Country(R.drawable.china, "Trung Quốc", "Bắc Kinh", "1,428.6 triệu", "9,596,961 km²", "153 người/km²", "18,48%"));
        countries.add(new Country(R.drawable.us, "Mỹ", "Washington, D.C.", "331 triệu", "9,525,067 km²", "36 người/km²", "4,24%"));
        countries.add(new Country(R.drawable.indo, "Indonesia", "Jakarta", "273 triệu", "1,904,569 km²", "143 người/km²", "3,60%"));
        countries.add(new Country(R.drawable.pakis, "Pakistan", "Islamabad", "225 triệu", "881,913 km²", "255 người/km²", "2,83%"));
        countries.add(new Country(R.drawable.nigeria, "Nigeria", "Abuja", "206 triệu", "923,768 km²", "223 người/km²", "2,60%"));
        countries.add(new Country(R.drawable.brazil, "Brazil", "Brasília", "213 triệu", "8,515,767 km²", "25 người/km²", "2,90%"));
        countries.add(new Country(R.drawable.bangladesh, "Bangladesh", "Dhaka", "166 triệu", "147,570 km²", "1,126 người/km²", "2,10%"));


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CountryAdapter adapter = new CountryAdapter(this, (ArrayList<Country>) countries);
        recyclerView.setAdapter(adapter);
    }
}