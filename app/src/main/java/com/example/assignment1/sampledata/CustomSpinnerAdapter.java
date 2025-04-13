package com.example.assignment1.sampledata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.assignment1.R;

import java.util.List;

public class CustomSpinnerAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final List<String> items;

    public CustomSpinnerAdapter(@NonNull Context context, @NonNull List<String> items) {
        super(context, 0, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // This is for the spinner when not expanded
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.spinner_item, parent, false);
        }

        TextView spinnerText = convertView.findViewById(R.id.spinnerText);
        spinnerText.setText(items.get(position));

        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // This is for the dropdown list
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.spinner_dropdown_item, parent, false);
        }

        TextView dropdownText = convertView.findViewById(R.id.dropdownText);
        dropdownText.setText(items.get(position));

        return convertView;
    }
}
