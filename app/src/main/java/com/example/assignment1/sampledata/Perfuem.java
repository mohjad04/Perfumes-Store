package com.example.assignment1.sampledata;

import java.util.ArrayList;
import java.util.List;

public class Perfuem {

    private String brand;
    private String model;
    private double price;
    private String imgSrc;
    private List<String> brands = new ArrayList<>();

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;

        for (int i =0;i<brands.size();i++){
            if(this.getBrand().equalsIgnoreCase(brands.get(i))){
                continue;
            }
            brands.add(brand);
        }

    }



    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc =  this.getBrand().toLowerCase().replaceAll(" ", "_") + "_" +
                this.getModel().toLowerCase().replaceAll(" ", "_");;
    }

    public List<String> getBrands() {
        return brands;
    }

    public void setBrands(List<String> brands) {
        this.brands = brands;
    }

    @Override
    public String toString() {
        return "Perfuem{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", imgSrc='" + imgSrc + '\'' +
                ", brands=" + brands +
                '}';
    }
}
