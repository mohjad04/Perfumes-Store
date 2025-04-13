package com.example.assignment1;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

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

import java.util.Arrays;
import java.util.List;

public class GenderPage extends AppCompatActivity {

    private ListView res;
    private Spinner genSpinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_gender_page);

        Intent intent = getIntent();
        setView();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void setView(){
        res = findViewById(R.id.genList);

         genSpinner = findViewById(R.id.genderspn);
        List<String> genders = Arrays.asList("Male", "Female", "Unisex", "All");

        CustomSpinnerAdapter genadp = new CustomSpinnerAdapter(this, genders);
        genSpinner.setAdapter(genadp);


        IPrefumesDA perfumes = new PerfumesDA();
        List<Perfuem> perfuemList = perfumes.getPerfumes();

        PerfumeAdapter adapter = new PerfumeAdapter(GenderPage.this, perfuemList);
        res.setAdapter(adapter);


    }





}