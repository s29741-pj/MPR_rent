package com.example.carrental;

import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class CarStorage {
    public ArrayList<Car> carsList = new ArrayList<>();

    public CarStorage() {
        carsList.add(new Car("SCFEKBBK1DGD16518","Aston Martin","DB9","Premium",2200));
        carsList.add(new Car("SCBFR7ZA7DC078111","Bentley","Continental","Premium",2150));
        carsList.add(new Car("KLAJB82Z91K707247","Daewoo","Nubira","Classic",300));
        carsList.add(new Car("KLATA5264XB445999","Daewoo","Lanos","Classic",200));
        carsList.add(new Car("3C3CFFAR5DT672600","Fiat","500","Daily",400));
        carsList.add(new Car("WVWPD63BX3P383153","Volkswagen","Passat","Daily",600));
    }


    public float getPrice(String vin) {
        for (Car carFromList : carsList) {
            if(carFromList.getVin().equals(vin)) {
               return carFromList.getPricePerDay();
            }
        }
        System.out.println("Car with VIN " + vin + " not found.");
        throw new IllegalArgumentException("Car with VIN " + vin + " not found.");
    }



}
