package com.example.assignment1.sampledata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PerfumesDA implements IPrefumesDA {

    private List<Perfuem> perfuems = new ArrayList<>();

    public PerfumesDA() {
        addPerfume("Dior", "Sauvage", 95.00);
        addPerfume("Chanel", "Bleu de Chanel", 120.00);
        addPerfume("Yves Saint Laurent", "La Nuit de L’Homme", 110.00);
        addPerfume("Creed", "Aventus", 435.00);
        addPerfume("Tom Ford", "Oud Wood", 263.00);
        addPerfume("Giorgio Armani", "Acqua di Giò", 105.00);
        addPerfume("Versace", "Eros", 85.00);
        addPerfume("Dolce & Gabbana", "Light Blue", 95.00);
        addPerfume("Paco Rabanne", "1 Million", 88.00);
        addPerfume("Jean Paul Gaultier", "Le Male", 100.00);
        addPerfume("Hugo Boss", "Boss Bottled", 90.00);
        addPerfume("Calvin Klein", "Eternity", 70.00);
        addPerfume("Azzaro", "Wanted", 75.00);
        addPerfume("Montblanc", "Explorer", 85.00);
        addPerfume("Maison Margiela", "Replica Jazz Club", 144.00);
        addPerfume("Burberry", "Hero", 102.00);
        addPerfume("Valentino", "Uomo Born In Roma", 130.00);
        addPerfume("Bvlgari", "Man in Black", 110.00);
        addPerfume("Hermès", "Terre d’Hermès", 125.00);
        addPerfume("Jo Malone", "Wood Sage & Sea Salt", 145.00);
    }

    private void addPerfume(String brand, String model, double price) {
        Perfuem p = new Perfuem();
        p.setBrand(brand);
        p.setModel(model);
        p.setPrice(price);
    }


    @Override
    public List<Perfuem> getPerfumes(String brand) {
        List<Perfuem> brPerfumes = new ArrayList<>();

        for ( Perfuem p : perfuems){
            if (p.getBrand().equalsIgnoreCase(brand)){
                brPerfumes.add(p);
            }
        }

        return brPerfumes;
    }
}
