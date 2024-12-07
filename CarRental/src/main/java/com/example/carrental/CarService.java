package com.example.carrental;

import org.springframework.stereotype.Component;


@Component
public class CarService {





    public void checkIfAvailable(RentService rentService, RentalStorage rentalStorage, CustomerStorage customerStorage,int customerID, CarStorage carStorage) {
        setCarPrice(carStorage, customerStorage, customerID);
        if (rentalStorage.checkIfAvailable(customerStorage, customerID)) {
            rentService.uploadNewCustomer(rentalStorage, customerStorage, customerID);
            System.out.println("New rental added");
        } else {
            System.out.println("Rental not available, please check the dates provided.");
//            throw new IllegalArgumentException("Wrong rent start/end date provided.");
        }

    }

    private void setCarPrice(CarStorage carStorage, CustomerStorage customerStorage, int customerID) {
        customerStorage.getCustomer(customerID).setPrice(carStorage.getPrice(customerStorage.getCustomer(customerID).getSelectedCarVin()));
    }

//    getters for RentService

//    public Customer getCustomer(int id){
//        return customers.get(id);
//    }

//    public int getNewCustomer(){
//        return customers.size()-1;
//    }

//    public ArrayList<Customer> getCustomersList() {
//        return customers;
//    }

//    public String getRentCarVin(int id){
//        return customers.get(id).getSelectedCarVin();
//    }

//    public int getCustomerId(int id){
//        return customers.get(id).getCustomerId();
//    }

//    public LocalDate getCustomerRentStart(int id){
//        return customers.get(id).getSelectedRentStart();
//    }

//    public LocalDate getCustomerRentEnd(int id){
//        return customers.get(id).getSelectedRentEnd();
//    }
//
//    public float getCustomerPrice(int id){
//        return customers.get(id).getPrice();
//    }
}
