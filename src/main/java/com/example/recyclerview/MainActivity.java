package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CountryListAdapter countryListAdapter;
    ArrayList<Country> countryList;
    private RecyclerView.LayoutManager linearLayoutManager, gridLayoutManager;

    Button btnChange;
    boolean layoutType = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        btnChange = findViewById(R.id.btnChange);
        countryList = new ArrayList<>();

        countryList.add(new Country(R.drawable.car_mercedes, "Mercedes", 030));
        countryList.add(new Country(R.drawable.car_toyota, "Toyota", 040));
        countryList.add(new Country(R.drawable.car_nissan, "Nissan", 050));
        countryList.add(new Country(R.drawable.car_opel, "Opel", 060));
        countryList.add(new Country(R.drawable.car_rolls-royse, "Rolls-Royse", 070));
        countryList.add(new Country(R.drawable.car_infinity, "Infinity", 080));

        countryListAdapter = new CountryListAdapter(this, countryList);

        linearLayoutManager = new LinearLayoutManager(this);
        gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(countryListAdapter);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutType = !layoutType;
                if(layoutType) {
                    recyclerView.setLayoutManager(gridLayoutManager);
                    countryList.remove(0);
                }else {
                    recyclerView.setLayoutManager(linearLayoutManager);
                }

                countryListAdapter.notifyDataSetChanged();

            }
        });
    }
}