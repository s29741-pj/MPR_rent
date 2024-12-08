package com.example.carrental;

import org.springframework.stereotype.Component;

@Component
public class RentService {

    public void uploadNewRent (boolean carServiceCheck,RentalStorage rentalStorage, CustomerStorage customerStorage, int customerID) {
        if(carServiceCheck) {
            rentalStorage.addNewRental(
                    new Rent(
                            customerStorage.getCustomer(customerID).getSelectedCarVin(),
                            customerStorage.getCustomer(customerID).getCustomerID(),
                            customerStorage.getCustomer(customerID).getSelectedRentStart(),
                            customerStorage.getCustomer(customerID).getSelectedRentEnd(),
                            customerStorage.getCustomer(customerID).getPrice()
                    )
            );
            System.out.println("Rent was added");
        }else{
            System.out.println("Rent was not added");
        }
    }
}




