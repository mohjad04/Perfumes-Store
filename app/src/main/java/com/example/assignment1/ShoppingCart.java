package com.example.assignment1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.assignment1.sampledata.Perfuem;
import com.example.assignment1.sampledata.PerfumeAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class ShoppingCart extends AppCompatActivity {
    private ListView cartlist;
    private Button checkedbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shopping_cart);

        Intent intent =getIntent();
        getCartItems();
        setCheckedbtn();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }



    private void getCartItems(){
        cartlist =  findViewById(R.id.cartlist);

        SharedPreferences prefs = getSharedPreferences("cart_pref", MODE_PRIVATE);
        String cartJson = prefs.getString("cart_items", "[]");

        Gson gson = new Gson();
        List<Perfuem> cartItems = gson.fromJson(cartJson, new TypeToken<List<Perfuem>>(){}.getType());

        PerfumeAdapter adapter = new PerfumeAdapter(ShoppingCart.this, cartItems,true);
        cartlist.setAdapter(adapter);

    }

    private void setCheckedbtn(){
     checkedbtn = findViewById(R.id.checkedbtn);

     checkedbtn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             creatIntentCheck();
         }
     });
    }


    public void creatIntentCheck (){
        Intent check = new Intent (this, checkOut.class);
        startActivity(check);
    }

















}