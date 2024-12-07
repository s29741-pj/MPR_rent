package com.example.carrental;

import org.springframework.stereotype.Component;

@Component
public class RentService {

//    to be refactored after moving customers from CarService
//    public void uploadCustomersList(RentalStorage rentalStorage, CarService carService) {
//        for (CustomerStorage customerStorage : carService.getCustomersList()) {
//            rentalStorage.addNewRental(
//                    new Rent(
//                            carService.getRentCarVin(customerStorage.getCustomerId()),
//                            carService.getCustomerId(customerStorage.getCustomerId()),
//                            carService.getCustomerRentStart(customerStorage.getCustomerId()),
//                            carService.getCustomerRentEnd(customerStorage.getCustomerId()),
//                            carService.getCustomerPrice(customerStorage.getCustomerId())
//                    )
//            );
//        }
//    }
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




