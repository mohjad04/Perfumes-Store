package com.example.assignment1.sampledata;

import java.util.ArrayList;
import java.util.List;

public class Perfuem {

    private String brand;
    private String model;
    private double price;
    private String imgSrc;
    String Gender;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    @Override
    public String toString() {
        return "Perfuem{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", imgSrc='" + imgSrc + '\'' +
                '}';
    }
}
