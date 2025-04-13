package com.example.assignment1.sampledata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PerfumesDA implements IPrefumesDA {

    private List<Perfuem> perfuems = new ArrayList<>();

    public PerfumesDA() {
        addPerfume("dior", "sauvage", 95.00);
        addPerfume("chanel", "bleu de chanel", 120.00);
        addPerfume("Creed", "Aventus", 435.00);
        addPerfume("Tom Ford", "Oud Wood", 263.00);
        addPerfume("Giorgio Armani", "Acqua di Gio", 105.00);
        addPerfume("Versace", "Eros", 85.00);
        addPerfume("Dolce Gabbana", "Light Blue", 95.00);
        addPerfume("Paco Rabanne", "1 Million", 88.00);
        addPerfume("Jean Paul Gaultier", "Le Male", 100.00);
        addPerfume("Hugo Boss", "Boss Bottled", 90.00);
        addPerfume("Calvin Klein", "Eternity", 70.00);
        addPerfume("Azzaro", "Wanted", 75.00);
        addPerfume("Montblanc", "Explorer", 85.00);
        addPerfume("Burberry", "Hero", 102.00);
        addPerfume("Bvlgari", "Man in Black", 110.00);
    }

    private void addPerfume(String brand, String model, double price) {
        Perfuem p = new Perfuem();
        p.setBrand(brand);
        p.setModel(model);
        p.setPrice(price);
        perfuems.add(p);
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
    }



