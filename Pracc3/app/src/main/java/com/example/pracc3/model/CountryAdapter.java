package com.example.pracc3.model;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pracc3.CountryDetailActivity;
import com.example.pracc3.R;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {
    private ArrayList<Country> countries;
    private Context context;

    public CountryAdapter(Context context, ArrayList<Country> countries) {
        this.context = context;
        this.countries = countries;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Country country = countries.get(position);
        holder.Name.setText(country.getNation());
        holder.Capital.setText(country.getCapital());
        holder.Population.setText(country.getPopulation());
        holder.Area.setText(country.getArea());
        holder.Destiny.setText(country.getDestiny());
        holder.World_Share.setText(country.getWorldShare());
        holder.img.setImageResource(country.getFlag());


        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CountryDetailActivity.class);
                intent.putExtra("country", country);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView Name;
        TextView Capital;
        TextView Population;
        TextView Area;
        TextView Destiny;
        TextView World_Share;

        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageView);
            Name = itemView.findViewById(R.id.Name);
            Capital = itemView.findViewById(R.id.Capital);
            Population = itemView.findViewById(R.id.Population);
            Area = itemView.findViewById(R.id.Area);
            Destiny = itemView.findViewById(R.id.Destiny);
            World_Share = itemView.findViewById(R.id.WorldShare);
        }
    }
}