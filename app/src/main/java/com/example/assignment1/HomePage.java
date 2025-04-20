package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomePage extends AppCompatActivity {
    private Button srchbtn;
    private Button genbtn;
    private Button cartbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_page);

        Intent intent = getIntent();

        handleButtons();







        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void handleButtons(){
        srchbtn = findViewById(R.id.srchbtn);
        genbtn = findViewById(R.id.genbtn);
        cartbtn = findViewById(R.id.cartbtn);

        srchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                creatIntentSearch();
            }
        });

        genbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                creatIntentGender();
            }
        });

        cartbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                creatIntentCart();
            }
        });


    }


    public void creatIntentSearch (){
        Intent search = new Intent (this, Search.class);
        startActivity(search);
    }


    public void creatIntentGender (){
        Intent gender = new Intent (this, GenderPage.class);
        startActivity(gender);
    }


    public void creatIntentCart (){
        Intent cart = new Intent (this, ShoppingCart.class);
        startActivity(cart);
    }







}