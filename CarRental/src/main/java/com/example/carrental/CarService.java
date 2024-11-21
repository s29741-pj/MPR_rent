package com.example.carrental;

import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.Calendar;

@Component
public class CarService {

    ArrayList<Customer> customers = new ArrayList<>();


    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("New customer added");
    }

    private void checkCarPrice(CarStorage carStorage, int id){
        getCustomer(id).setPrice(carStorage.getPrice(getCustomer(id).getSelectedCarVin()));
    }

//    public void checkCarPriceNewCustomer(CarStorage carStorage){
//        this.getCustomer(this.getNewCustomer()).setPrice(carStorage.getPrice(this.getCustomer(this.getNewCustomer()).getSelectedCarVin()));
//    }


    public void checkIfAvailable(RentService rentService,RentalStorage rentalStorage, Customer customer,CarStorage carStorage, int id){
        checkCarPrice(carStorage,id);
        if(rentalStorage.checkIfAvailable(customer)){
            rentService.uploadNewCustomer(rentalStorage,this);
            System.out.println("New rental added");
        }else{
            System.out.println("Rental not available, please check the dates provided.");
//            throw new IllegalArgumentException("Wrong rent start/end date provided.");
        }

    }

//    getters for RentService

    public Customer getCustomer(int id){
        return customers.get(id);
    }

    public int getNewCustomer(){
        return customers.size()-1;
    }

    public ArrayList<Customer> getCustomersList() {
        return customers;
    }

    public String getRentCarVin(int id){
        return customers.get(id).getSelectedCarVin();
    }

    public int getCustomerId(int id){
        return customers.get(id).getCustomerId();
    }

    public Calendar getCustomerRentStart(int id){
        return customers.get(id).getSelectedRentStart();
    }

    public Calendar getCustomerRentEnd(int id){
        return customers.get(id).getSelectedRentEnd();
    }

    public float getCustomerPrice(int id){
        return customers.get(id).getPrice();
    }
}
