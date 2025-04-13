package com.example.assignment1.sampledata;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.assignment1.R;
import com.example.assignment1.sampledata.Perfuem;

import java.util.List;

public class PerfumeAdapter extends ArrayAdapter<Perfuem> {

    public PerfumeAdapter(@NonNull Context context, @NonNull List<Perfuem> perfumes) {
        super(context, 0, perfumes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            // Inflate the layout using the parent
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_custom_list, parent, false);
        }

        Perfuem perfume = getItem(position);

        TextView brandModel = convertView.findViewById(R.id.brandModel);
        TextView price = convertView.findViewById(R.id.price);
        ImageView image = convertView.findViewById(R.id.perfumeImage);

        brandModel.setText(perfume.getBrand() + " - " + perfume.getModel());
        price.setText("$" + perfume.getPrice());

        // Image mapping example (name must match drawable name like "dior_sauvage")
        String imageName = perfume.getBrand().toLowerCase().replaceAll(" ", "_") + "_" +
                perfume.getModel().toLowerCase().replaceAll(" ", "_");

        int imageResId = getContext().getResources().getIdentifier(imageName, "drawable", getContext().getPackageName());

        if (imageResId != 0) {
            image.setImageResource(imageResId);
        } else {
            image.setImageResource(R.drawable.ic_launcher_background); // fallback
        }

        // Return the item view
        return convertView;
    }

}
