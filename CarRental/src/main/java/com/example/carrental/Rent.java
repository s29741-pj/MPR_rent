package com.example.carrental;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

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
        setTotalPrice(price, selectedRentStart, selectedRentEnd);
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


//    public void setRentEnd(Calendar selectedRentEnd) {
//        int year = selectedRentEnd.get(Calendar.YEAR);
//        int month = selectedRentEnd.get(Calendar.MONTH);
//        int day = selectedRentEnd.get(Calendar.DAY_OF_MONTH);
//        this.rentEnd.set(year, month, day);
//    }

    public void setTotalPrice (float price, LocalDate selectedRentStart, LocalDate selectedRentEnd)
    {
        int rentPeriod = calculateRentPeriod(selectedRentStart, selectedRentEnd);
         this.rentPrice = price * rentPeriod;
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

//        long rentStartMillis = selectedRentStart.getTimeInMillis();
//        long rentEndMillis = selectedRentEnd.getTimeInMillis();
//        long millisDiff = Math.abs(rentEndMillis - rentStartMillis);

        return period.getDays();
    }

}
