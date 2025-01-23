package com.example.carrental;

import org.springframework.stereotype.Component;


@Component
public class CarService {


    public void newRentalCheck(RentService rentService, RentalStorage rentalStorage, CustomerStorage customerStorage, int customerID, CarStorage carStorage) {
        if (rentService.checkIfAvailable(customerStorage, customerID, rentalStorage) && checkIfCarExists(carStorage, customerStorage.getCustomer(customerID).getSelectedCarVin())) {
            customerStorage.getCustomer(customerID).setPrice(calculateCarPrice(carStorage, customerStorage, customerID));
            rentService.uploadNewRent(rentalStorage, customerStorage, customerID);
            System.out.println("New rental added");
        } else {
            System.out.println("Rental not available, please check the dates provided.");
        }

    }

    public boolean checkIfCarExists(CarStorage carStorage, String vin) {
        return carStorage.checkIfExists(vin);
    }

    public float calculateCarPrice(CarStorage carStorage, CustomerStorage customerStorage, int customerID) {
        float rentPrice = carStorage.getPriceByVin(customerStorage.getCustomer(customerID).getSelectedCarVin()) * customerStorage.getCustomer(customerID).getRentDuration();
        return rentPrice;
    }


}
