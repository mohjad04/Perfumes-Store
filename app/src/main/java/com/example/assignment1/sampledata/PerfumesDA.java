package com.example.assignment1.sampledata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PerfumesDA implements IPrefumesDA {

    private List<Perfuem> perfuems = new ArrayList<>();
    private List<String> brands = new ArrayList<>();


    public PerfumesDA() {
        // Male perfumes
        addPerfume("dior", "sauvage", 95.00, "Male");
        addPerfume("chanel", "bleu de chanel", 120.00, "Male");
        addPerfume("Creed", "Aventus", 435.00, "Male");
        addPerfume("Tom Ford", "Oud Wood", 263.00, "Male");
        addPerfume("Giorgio Armani", "Acqua di Gio", 105.00, "Male");
        addPerfume("Versace", "Eros", 85.00, "Male");
        addPerfume("Dolce Gabbana", "Light Blue", 95.00, "Male");
        addPerfume("Paco Rabanne", "1 Million", 88.00, "Male");
        addPerfume("Jean Paul Gaultier", "Le Male", 100.00, "Male");
        addPerfume("Hugo Boss", "Boss Bottled", 90.00, "Male");
        addPerfume("Calvin Klein", "Eternity", 70.00, "Male");
        addPerfume("Azzaro", "Wanted", 75.00, "Male");
        addPerfume("Montblanc", "Explorer", 85.00, "Male");
        addPerfume("Burberry", "Hero", 102.00, "Male");
        addPerfume("Bvlgari", "Man in Black", 110.00, "Male");

        // Female perfumes (only those in the image)
        addPerfume("armani", "my way", 100.00, "Female");
        addPerfume("burberry", "her", 98.00, "Female");
        addPerfume("carolina herrera", "good girl", 115.00, "Female");
        addPerfume("chanel", "chance", 125.00, "Female");
        addPerfume("dior", "jadore", 130.00, "Female");
        addPerfume("gucci", "bloom", 110.00, "Female");
        addPerfume("marc jacobs", "daisy", 112.00, "Female");
        addPerfume("versace", "bright crystal", 89.00, "Female");
        addPerfume("viktor rolf", "flowerbomb", 118.00, "Female");

        //Unisex
        addPerfume("Tom Ford", "Tobacco Vanille", 350.00, "Unisex");
        addPerfume("Byredo", "Gypsy Water", 290.00, "Unisex");
        addPerfume("Diptyque", "Philosykos", 200.00, "Unisex");
        addPerfume("Creed", "Silver Mountain Water", 430.00, "Unisex");
        addPerfume("Le Labo", "Santal 33", 310.00, "Unisex");

    }


    private void addPerfume(String brand, String model, double price,String Gender) {
        Perfuem p = new Perfuem();
        p.setBrand(brand);
        p.setModel(model);
        p.setPrice(price);
        p.setGender(Gender);
        perfuems.add(p);

        if (!brands.contains(brand)) {
            brands.add(brand);
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



