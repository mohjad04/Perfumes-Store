package com.example.assignment1.sampledata;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.assignment1.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PerfumeAdapter extends ArrayAdapter<Perfuem> {

    private final SharedPreferences sharedPreferences;
    private final Gson gson = new Gson();
    private static final String PREF_NAME = "cart_prefs";
    private static final String CART_KEY = "cart_items";

    public PerfumeAdapter(@NonNull Context context, @NonNull List<Perfuem> perfumes) {
        super(context, 0, perfumes);
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_custom_list, parent, false);
        }

        Perfuem perfume = getItem(position);

        TextView brandModel = convertView.findViewById(R.id.brandModel);
        TextView price = convertView.findViewById(R.id.price);
        ImageView image = convertView.findViewById(R.id.perfumeImage);
        Button addToCartButton = convertView.findViewById(R.id.addToCartButton);

        if (perfume != null) {
            brandModel.setText(perfume.getBrand() + " - " + perfume.getModel());
            price.setText("$" + perfume.getPrice());

            // Dynamically load image based on name
            String imageName = perfume.getBrand().toLowerCase().replaceAll(" ", "_") + "_" +
                    perfume.getModel().toLowerCase().replaceAll(" ", "_");

            int imageResId = getContext().getResources().getIdentifier(imageName, "drawable", getContext().getPackageName());
            image.setImageResource(imageResId != 0 ? imageResId : R.drawable.ic_launcher_background);

            // Handle add to cart
            addToCartButton.setOnClickListener(v -> {
                if (addToCart(perfume)) {
                    Toast.makeText(getContext(), perfume.getModel() + " added to cart!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), perfume.getModel() + " is already in cart!", Toast.LENGTH_SHORT).show();
                }
            });
        }

        return convertView;
    }

    // Adds perfume to cart if not already present
    private boolean addToCart(Perfuem perfume) {
        List<Perfuem> cart = getCartItems();
        for (Perfuem item : cart) {
            if (item.getBrand().equalsIgnoreCase(perfume.getBrand()) &&
                    item.getModel().equalsIgnoreCase(perfume.getModel())) {
                return false; // already in cart
            }
        }
        cart.add(perfume);
        String json = gson.toJson(cart);
        sharedPreferences.edit().putString(CART_KEY, json).apply();
        return true;
    }

    // Get existing cart items from SharedPreferences
    private List<Perfuem> getCartItems() {
        String json = sharedPreferences.getString(CART_KEY, null);
        if (json != null) {
            Type type = new TypeToken<List<Perfuem>>() {}.getType();
            return gson.fromJson(json, type);
        }
        return new ArrayList<>();
    }
}
