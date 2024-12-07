package com.example.carrental;

import org.springframework.stereotype.Component;

@Component
public class RentService {

    public void uploadNewCustomer(RentalStorage rentalStorage, CustomerStorage customerStorage, int customerID) {
            rentalStorage.addNewRental(
                    new Rent(
                            customerStorage.getCustomer(customerID).getSelectedCarVin(),
                            customerStorage.getCustomer(customerID).getCustomerID(),
                            customerStorage.getCustomer(customerID).getSelectedRentStart(),
                            customerStorage.getCustomer(customerID).getSelectedRentEnd(),
                            customerStorage.getCustomer(customerID).getPrice()
                    )
            );

    }



    }




