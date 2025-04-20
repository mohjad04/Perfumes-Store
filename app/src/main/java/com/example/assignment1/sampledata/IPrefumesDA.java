package com.example.assignment1.sampledata;

import java.util.List;

public interface IPrefumesDA {

    List<Perfuem> getPerfumes();

    List<String> getBrands();
    List<Perfuem> getPerfumesByBrand(String brand);
}
