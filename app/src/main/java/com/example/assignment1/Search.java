package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.assignment1.sampledata.CustomSpinnerAdapter;
import com.example.assignment1.sampledata.IPrefumesDA;
import com.example.assignment1.sampledata.Perfuem;
import com.example.assignment1.sampledata.PerfumeAdapter;
import com.example.assignment1.sampledata.PerfumesDA;

import java.util.ArrayList;
import java.util.List;

public class Search extends AppCompatActivity {
    private EditText searchtxt;
    private ListView res;
    private Spinner brandsspn;
    private Button searchbtn;

    private SeekBar  priceBar;
    private TextView priceValue;
    IPrefumesDA perfumes = new PerfumesDA();
    List<Perfuem> perfuemList;
    List<Perfuem> satrtList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search);

        Intent intent =getIntent();

        setViews();
        setSearch();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }












    public void setSearch() {
        setSeek();
        res = findViewById(R.id.searchlist);
        satrtList = perfumes.getPerfumes();
        PerfumeAdapter adapter = new PerfumeAdapter(Search.this, satrtList,false);
        res.setAdapter(adapter);

        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedBrand = brandsspn.getSelectedItem().toString();
                String searchText = searchtxt.getText().toString().trim().toLowerCase();

                // Start with perfumes by brand (or all if none selected)
                if (!selectedBrand.isEmpty()) {
                    perfuemList = perfumes.getPerfumesByBrand(selectedBrand);
                } else {
                    perfuemList = perfumes.getPerfumes();
                }

                // Further filter by model name if search is not empty
                if (!searchText.isEmpty()) {
                    List<Perfuem> filteredList = new ArrayList<>();
                    for (Perfuem p : perfuemList) {
                        if (p.getModel().toLowerCase().contains(searchText)) {
                            filteredList.add(p);
                        }
                    }
                    perfuemList = filteredList;
                }

                int maxPrice = priceBar.getProgress();
                List<Perfuem> finalFiltered = new ArrayList<>();
                for (Perfuem p : perfuemList) {
                    if (p.getPrice() <= maxPrice) {
                        finalFiltered.add(p);
                    }
                    perfuemList = finalFiltered;
                }



                    // Set the adapter with final filtered list
                PerfumeAdapter adapter = new PerfumeAdapter(Search.this, perfuemList,false);
                res.setAdapter(adapter);
            }
        });
    }


    public void setViews(){
        searchtxt =  findViewById(R.id.searchtxt);
        searchbtn = findViewById(R.id.searchbtn);
        brandsspn = findViewById(R.id.brandsspn);

        List<String> brandsList = perfumes.getBrands();
        CustomSpinnerAdapter brands = new CustomSpinnerAdapter(this,brandsList);
        brandsspn.setAdapter(brands);
    }



    public void setSeek(){
         priceBar = findViewById(R.id.priceBar);
         priceValue = findViewById(R.id.priceValue);

        priceBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                priceValue.setText("Price: $" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

    }





}