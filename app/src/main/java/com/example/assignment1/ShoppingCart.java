package com.example.assignment1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shopping_cart);

        Intent intent =getIntent();
        getCartItems();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }



    private void getCartItems(){
        cartlist =  findViewById(R.id.cartlist);

        SharedPreferences prefs = getSharedPreferences("cart_prefs", MODE_PRIVATE);
        String cartJson = prefs.getString("cart_items", "[]");

        Gson gson = new Gson();
        List<Perfuem> cartItems = gson.fromJson(cartJson, new TypeToken<List<Perfuem>>(){}.getType());

        PerfumeAdapter adapter = new PerfumeAdapter(ShoppingCart.this, cartItems);
        cartlist.setAdapter(adapter);

    }




















}