package com.example.assignment1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment1.sampledata.Perfuem;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class checkOut extends AppCompatActivity {

    private EditText nameField, phoneField, locationField;
    private Button doneBtn, cancelBtn;
    private TextView totalPriceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        Intent intent = getIntent();

        nameField = findViewById(R.id.Nametxt);
        phoneField = findViewById(R.id.Phonetxt);
        locationField = findViewById(R.id.locationtxt);

        doneBtn = findViewById(R.id.donebtn);
        cancelBtn = findViewById(R.id.cancelbtn);
        setTotalPriceTextView();
        doneBtn.setOnClickListener(v -> handleCheckout());
        cancelBtn.setOnClickListener(v -> finish());
    }

    private void handleCheckout() {
        String name = nameField.getText().toString().trim();
        String phone = phoneField.getText().toString().trim();
        String location = locationField.getText().toString().trim();

        if (name.isEmpty() || phone.isEmpty() || location.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences prefs = getSharedPreferences("cart_prefs", MODE_PRIVATE);
        prefs.edit().remove("cart_items").apply();

        Toast.makeText(this, "Payment completed successfully!", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, HomePage.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    public void setTotalPriceTextView() {
        totalPriceTextView = findViewById(R.id.pricetxt);

        SharedPreferences prefs = getSharedPreferences("cart_pref", MODE_PRIVATE);
        String cartJson = prefs.getString("cart_items", "[]");

        Gson gson = new Gson();
        Perfuem[] perfumeArray = gson.fromJson(cartJson, Perfuem[].class);  // Fix variable name here

        // Convert array to list
        List<Perfuem> cartItems = new ArrayList<>(Arrays.asList(perfumeArray));

        // Calculate total
        double total = 0;
        for (Perfuem item : cartItems) {
            total += item.getPrice();
        }

        totalPriceTextView.setText("Total Price: $" + String.format("%.2f", total));
    }


}