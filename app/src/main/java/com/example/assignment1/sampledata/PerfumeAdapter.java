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

    private SharedPreferences sharedPreferences;
    private Gson gson = new Gson();
    private static final String PREF_NAME = "cart_pref";
    private static final String CART_KEY = "cart_items";

    private boolean isCartMode;

    public PerfumeAdapter(@NonNull Context context, @NonNull List<Perfuem> perfumes, boolean isCartMode) {
        super(context, 0, perfumes);
        this.isCartMode = isCartMode;
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
        Button actionButton = convertView.findViewById(R.id.addToCartButton);  // Can be Add or Delete

        brandModel.setText(perfume.getBrand() + " - " + perfume.getModel());
        price.setText("$" + perfume.getPrice());

        String imageName = perfume.getBrand().toLowerCase().replaceAll(" ", "_") + "_" +
                perfume.getModel().toLowerCase().replaceAll(" ", "_");

        int imageResId = getContext().getResources().getIdentifier(imageName, "drawable", getContext().getPackageName());
        image.setImageResource(imageResId != 0 ? imageResId : R.drawable.ic_launcher_background);

        if (isCartMode) {
            actionButton.setText("Delete");
            actionButton.setOnClickListener(v -> {
                removeFromCart(perfume);
                remove(perfume);  // Remove from ListView
                notifyDataSetChanged();
                Toast.makeText(getContext(), perfume.getModel() + " removed from cart", Toast.LENGTH_SHORT).show();
            });
        } else {
            actionButton.setText("Add to Cart");
            actionButton.setOnClickListener(v -> {
                addToCart(perfume);
                Toast.makeText(getContext(), perfume.getModel() + " added to cart", Toast.LENGTH_SHORT).show();
            });
        }

        return convertView;
    }

    private void addToCart(Perfuem perfume) {
        List<Perfuem> cart = getCartItems();
        cart.add(perfume);
        sharedPreferences.edit().putString(CART_KEY, gson.toJson(cart)).apply();
    }

    private void removeFromCart(Perfuem perfume) {
        List<Perfuem> cart = getCartItems();
        cart.removeIf(p -> p.getBrand().equals(perfume.getBrand()) && p.getModel().equals(perfume.getModel()));
        sharedPreferences.edit().putString(CART_KEY, gson.toJson(cart)).apply();
    }

    private List<Perfuem> getCartItems() {
        String json = sharedPreferences.getString(CART_KEY, null);
        Type type = new TypeToken<List<Perfuem>>() {}.getType();
        return json != null ? gson.fromJson(json, type) : new ArrayList<>();
    }
}
