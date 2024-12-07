package com.example.carrental;

import java.time.LocalDate;
import java.time.Period;


public class Rent {
    private String rentCarVin;
    private int customerId;
    private LocalDate rentStart;
    private LocalDate rentEnd;
    private float rentPrice;

    public Rent(String rentCarVin, int customerId, LocalDate selectedRentStart, LocalDate selectedRentEnd, float price) {
        this.rentCarVin = rentCarVin;
        this.customerId = customerId;
        this.rentStart = setRentStart(selectedRentStart);
        this.rentEnd = setRentEnd(selectedRentEnd);
        this.rentPrice = setTotalPrice(price, selectedRentStart, selectedRentEnd);
    }

//    setters

    public LocalDate setRentStart(LocalDate selectedRentStart) {
        int year = selectedRentStart.getYear();
        int month = selectedRentStart.getMonthValue();
        int day = selectedRentStart.getDayOfMonth();
        return LocalDate.of(year, month, day);
    }

    public LocalDate setRentEnd(LocalDate selectedRentEnd) {
        int year = selectedRentEnd.getYear();
        int month = selectedRentEnd.getMonthValue();
        int day = selectedRentEnd.getDayOfMonth();
        return LocalDate.of(year, month, day);
    }


    public float setTotalPrice (float price, LocalDate selectedRentStart, LocalDate selectedRentEnd)
    {
        int rentPeriod = calculateRentPeriod(selectedRentStart, selectedRentEnd);
        return price * rentPeriod;
    }

//    getters

    public String getRentCarVin() {
        return rentCarVin;
    }

    public LocalDate getRentStart(){
        return rentStart;
    }
    public LocalDate getRentEnd(){
        return rentEnd;
    }
//
    private int calculateRentPeriod(LocalDate selectedRentStart, LocalDate selectedRentEnd) {
        Period period = Period.between(selectedRentStart, selectedRentEnd);
        return period.getDays();
    }

}
