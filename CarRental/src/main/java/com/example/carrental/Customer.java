package com.example.carrental;

import java.time.LocalDate;
import java.util.Calendar;

public class Customer {
    private int customerID;
    private String selectedCarVin;
    private LocalDate selectedRentStart;
    private LocalDate selectedRentEnd;
    //   private Calendar selectedRentStart = Calendar.getInstance();
    //   private Calendar selectedRentEnd = Calendar.getInstance();
    private float price;


    public Customer(int customerID, String selectedCarVin, String selectedRentStart, String selectedRentEnd) {
        this.customerID = customerID;
        this.selectedCarVin = selectedCarVin;
        this.selectedRentStart = LocalDate.parse(selectedRentStart);
        this.selectedRentEnd = LocalDate.parse(selectedRentEnd);
//        setSelectedRentStart(selectedRentStart);
//        setSelectedRentEnd(selectedRentEnd);
    }

//    setters

//    public void setSelectedRentStart(String selectedRentStart) {
//        int year = Integer.parseInt(selectedRentStart.substring(0, 4));
//        int month = Integer.parseInt(selectedRentStart.substring(5, 7));
//        int day = Integer.parseInt(selectedRentStart.substring(8));
//        this.selectedRentStart.set(year, month, day);
//    }
//    public void setSelectedRentEnd(String selectedRentEnd) {
//        int year = Integer.parseInt(selectedRentEnd.substring(0, 4));
//        int month = Integer.parseInt(selectedRentEnd.substring(5, 7));
//        int day = Integer.parseInt(selectedRentEnd.substring(8));
//        this.selectedRentEnd.set(year, month, day);
//    }

    public void setPrice(float price) {
        this.price = price;
    }

//    getters

    public int getCustomerId() {
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


}
