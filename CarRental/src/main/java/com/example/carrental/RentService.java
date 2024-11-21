package com.example.carrental;

import org.springframework.stereotype.Component;

@Component
public class RentService {


    public void uploadCustomersList(RentalStorage rentalStorage, CarService carService) {
        for (Customer customer : carService.getCustomersList()) {
            rentalStorage.addNewRental(
                    new Rent(
                            carService.getRentCarVin(customer.getCustomerId()),
                            carService.getCustomerId(customer.getCustomerId()),
                            carService.getCustomerRentStart(customer.getCustomerId()),
                            carService.getCustomerRentEnd(customer.getCustomerId()),
                            carService.getCustomerPrice(customer.getCustomerId())
                    )
            );
        }
    }
    public void uploadNewCustomer(RentalStorage rentalStorage, CarService carService) {
            rentalStorage.addNewRental(
                    new Rent(
                            carService.getRentCarVin(carService.getNewCustomer()),
                            carService.getCustomerId(carService.getNewCustomer()),
                            carService.getCustomerRentStart(carService.getNewCustomer()),
                            carService.getCustomerRentEnd(carService.getNewCustomer()),
                            carService.getCustomerPrice(carService.getNewCustomer())
                    )
            );

    }



    }




