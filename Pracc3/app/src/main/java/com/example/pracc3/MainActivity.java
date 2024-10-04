package com.example.pracc3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
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
        countries.add(new Country(R.drawable.india,"Ấn Độ","New Delhi","1,428.6","2,973,190","481 people/km2","17,76%"));
        countries.add(new Country(R.drawable.china,"China","Thượng Hải","1,428.6","2,973,190","481 people/km2","17,76%"));
        countries.add(new Country(R.drawable.us,"Mỹ","Oá Sing ton","1,428.6","2,973,190","481 people/km2","17,76%"));
        countries.add(new Country(R.drawable.indo,"Indo","New Delhi","1,428.6","2,973,190","481 people/km2","17,76%"));
        countries.add(new Country(R.drawable.pakis,"Pakistan","New Delhi","1,428.6","2,973,190","481 people/km2","17,76%"));
        countries.add(new Country(R.drawable.nigeria,"Nigeria","New Delhi","1,428.6","2,973,190","481 people/km2","17,76%"));
        countries.add(new Country(R.drawable.brazil,"Brazil","New Delhi","1,428.6","2,973,190","481 people/km2","17,76%"));
        countries.add(new Country(R.drawable.bangladesh,"Bangladesh","New Delhi","1,428.6","2,973,190","481 people/km2","17,76%"));
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CountryAdapter adapter = new CountryAdapter((ArrayList<Country>) countries);
        recyclerView.setAdapter(adapter);

    };
}
