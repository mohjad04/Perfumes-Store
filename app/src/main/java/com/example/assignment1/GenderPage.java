package com.example.assignment1;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenderPage extends AppCompatActivity {

    private ListView res;
    private Spinner genSpinner;
    IPrefumesDA perfumes = new PerfumesDA();
    List<Perfuem> perfuemList;
    private Button gensrchbtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_gender_page);

        Intent intent = getIntent();
        setView();
        genSearch();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void setView(){
        res = findViewById(R.id.genList);
        gensrchbtn = findViewById(R.id.gensrchbtn);

         genSpinner = findViewById(R.id.genderspn);
        List<String> genders = Arrays.asList("Male", "Female", "Unisex", "All");

        CustomSpinnerAdapter genadp = new CustomSpinnerAdapter(this, genders);
        genSpinner.setAdapter(genadp);


      perfuemList = perfumes.getPerfumes();

        PerfumeAdapter adapter = new PerfumeAdapter(GenderPage.this, perfuemList,false);
        res.setAdapter(adapter);


    }


    public void genSearch() {
        gensrchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gen = genSpinner.getSelectedItem().toString(); // Moved inside
                List<Perfuem> finalRes = new ArrayList<>();

                if (!gen.isEmpty() && !gen.equalsIgnoreCase("All")) {
                    for (Perfuem p : perfuemList) {
                        if (p.getGender().equalsIgnoreCase(gen)) {
                            finalRes.add(p);
                        }
                    }
                } else {
                    finalRes.addAll(perfuemList); // Show all if "All" is selected
                }

                PerfumeAdapter adapter = new PerfumeAdapter(GenderPage.this, finalRes,false);
                res.setAdapter(adapter);
            }
        });
    }




}