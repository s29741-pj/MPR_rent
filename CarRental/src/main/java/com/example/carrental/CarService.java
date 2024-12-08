package com.example.carrental;

import org.springframework.stereotype.Component;


@Component
public class CarService {


    public void checkIfAvailable(RentService rentService, RentalStorage rentalStorage, CustomerStorage customerStorage, int customerID, CarStorage carStorage) {
        setCarPrice(carStorage, customerStorage, customerID);
        if (rentalStorage.checkIfAvailable(customerStorage, customerID)) {
            rentService.uploadNewRent(true, rentalStorage, customerStorage, customerID);
            System.out.println("New rental added");
        } else {
            System.out.println("Rental not available, please check the dates provided.");
        }

    }

    private void setCarPrice(CarStorage carStorage, CustomerStorage customerStorage, int customerID) {
        customerStorage.getCustomer(customerID).setPrice(carStorage.getPrice(customerStorage.getCustomer(customerID).getSelectedCarVin()));
    }

}
