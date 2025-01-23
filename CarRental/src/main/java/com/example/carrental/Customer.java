package com.example.carrental;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.DAYS;

public class Customer {
    private int customerID;
    private String selectedCarVin;
    private LocalDate selectedRentStart;
    private LocalDate selectedRentEnd;
    private long rentDuration;
    private float price;


    public Customer (int customerID, String selectedCarVin, String selectedRentStart, String selectedRentEnd) {
        this.customerID = customerID;
        this.selectedCarVin = selectedCarVin;
        this.selectedRentStart = LocalDate.parse(selectedRentStart);
        this.selectedRentEnd = LocalDate.parse(selectedRentEnd);
        this.rentDuration = DAYS.between(LocalDate.parse(selectedRentStart), LocalDate.parse(selectedRentEnd));
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getSelectedCarVin() {
        return selectedCarVin;
    }

    public LocalDate getSelectedRentStart() {
        return selectedRentStart;
    }

    public LocalDate getSelectedRentEnd() {
        return selectedRentEnd;
    }

    public float getPrice() {
        return price;
    }

    public long getRentDuration() {
        return rentDuration;
    }
}
