package com.example.carrental;

public class Car {
   private String vin;
   private String brand;
   private String model;
   private String type;
   private float pricePerDay;


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
