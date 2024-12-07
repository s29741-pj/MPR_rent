package com.example.carrental;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;


@Component
public class CustomerStorage {


    ArrayList<Customer> customerStorage = new ArrayList<>();


    public void addCustomer(Customer customer) {
        customerStorage.add(customer);
        System.out.println("New customer added");
    }


//    getters

    public Customer getCustomer(int id){
        return customerStorage.get(id);
    }

    public int getNewCustomer(){
        return customerStorage.size()-1;
    }

    public ArrayList<Customer> getCustomersList() {
        return customerStorage;
    }



}
