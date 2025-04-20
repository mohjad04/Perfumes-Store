package com.example.assignment1.sampledata;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PerfumesDA implements IPrefumesDA {

    private List<Perfuem> perfuems = new ArrayList<>();
    private List<String> brands = new ArrayList<>();


    public PerfumesDA() {
        // Male perfumes
        addPerfume("dior", "sauvage", 95.00, "Male",0);
        addPerfume("chanel", "bleu de chanel", 120.00, "Male",30);
        addPerfume("Creed", "Aventus", 435.00, "Male",30);
        addPerfume("Tom Ford", "Oud Wood", 263.00, "Male",30);
        addPerfume("Giorgio Armani", "Acqua di Gio", 105.00, "Male",30);
        addPerfume("Versace", "Eros", 85.00, "Male",30);
        addPerfume("Dolce Gabbana", "Light Blue", 95.00, "Male",30);
        addPerfume("Paco Rabanne", "1 Million", 88.00, "Male",30);
        addPerfume("Jean Paul Gaultier", "Le Male", 100.00, "Male",30);
        addPerfume("Hugo Boss", "Boss Bottled", 90.00, "Male",30);
        addPerfume("Calvin Klein", "Eternity", 70.00, "Male",30);
        addPerfume("Azzaro", "Wanted", 75.00, "Male",30);
        addPerfume("Montblanc", "Explorer", 85.00, "Male",30);
        addPerfume("Burberry", "Hero", 102.00, "Male",30);
        addPerfume("Bvlgari", "Man in Black", 110.00, "Male",30);

        // Female perfumes (only those in the image)
        addPerfume("armani", "my way", 100.00, "Female",30);
        addPerfume("burberry", "her", 98.00, "Female",30);
        addPerfume("carolina herrera", "good girl", 115.00, "Female",30);
        addPerfume("chanel", "chance", 125.00, "Female",30);
        addPerfume("dior", "jadore", 130.00, "Female",30);
        addPerfume("gucci", "bloom", 110.00, "Female",30);
        addPerfume("marc jacobs", "daisy", 112.00, "Female",30);
        addPerfume("versace", "bright crystal", 89.00, "Female",30);
        addPerfume("viktor rolf", "flowerbomb", 118.00, "Female",30);

        //Unisex
        addPerfume("Tom Ford", "Tobacco Vanille", 350.00, "Unisex",20);
        addPerfume("Byredo", "Gypsy Water", 290.00, "Unisex",20);
        addPerfume("Diptyque", "Philosykos", 200.00, "Unisex",20);
        addPerfume("Creed", "Silver Mountain Water", 430.00, "Unisex",20);
        addPerfume("Le Labo", "Santal 33", 310.00, "Unisex", 20);



    }


    private void addPerfume(String brand, String model, double price,String Gender,int quantity) {
        Perfuem p = new Perfuem();
        p.setBrand(brand);
        p.setModel(model);
        p.setPrice(price);
        p.setGender(Gender);
        p.setQuantity(quantity);
        perfuems.add(p);

        if (!brands.contains(brand)) {
            brands.add(brand);
        }
    }


    public void decreaseQuantity(String brand, String model) {
        for (Perfuem perfume : perfuems) {
            if (perfume.getBrand().equals(brand) && perfume.getModel().equals(model)) {
                if (perfume.getQuantity() > 0) {
                    perfume.setQuantity(perfume.getQuantity() - 1);
                }
                break;
            }
        }
    }



    @Override
    public List<Perfuem> getPerfumes() {
        return perfuems;
    }

    @Override
    public List<Perfuem> getPerfumesByBrand(String brand) {
        List<Perfuem> brPerfumes = new ArrayList<>();

        for ( Perfuem p : perfuems){
            if (p.getBrand().equalsIgnoreCase(brand)){
                brPerfumes.add(p);
            }
        }

        return brPerfumes;
    }

    @Override
    public List<String> getBrands() {
        return brands;
    }


}

