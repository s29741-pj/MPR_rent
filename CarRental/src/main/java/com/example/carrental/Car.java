package com.example.carrental;

public class Car {
    private String vin;
    private String brand;
    private String model;
    private String type;
    private float pricePerDay;

    //non-parameter constructor - for tests only
    public Car() {
    }

    public Car(String vin, String brand, String model, String type, float price) {
        this.vin = vin;
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.pricePerDay = price;
    }

    //copying constructor
    public Car(Car original) {
        this.vin = original.vin;
        this.brand = original.brand;
        this.model = original.model;
        this.type = original.type;
        this.pricePerDay = original.pricePerDay;
    }

    //    setters

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPricePerDay(float pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    //    getters
    public String getVin() {
        return vin;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public float getPricePerDay() {
        return pricePerDay;
    }
}
