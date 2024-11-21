package com.example.carrental;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Rent {
    private String rentCarVin;
    private int customerId;
    private Calendar rentStart = Calendar.getInstance();
    private Calendar rentEnd = Calendar.getInstance();
    private float rentPrice;

    public Rent(String rentCarVin, int customerId, Calendar selectedRentStart, Calendar selectedRentEnd, float price) {
        this.rentCarVin = rentCarVin;
        this.customerId = customerId;
        setRentStart(selectedRentStart);
        setRentEnd(selectedRentEnd);
        setTotalPrice(price, selectedRentStart, selectedRentEnd);
    }

//    setters

    public void setRentStart(Calendar selectedRentStart) {
        int year = selectedRentStart.get(Calendar.YEAR);
        int month = selectedRentStart.get(Calendar.MONTH);
        int day = selectedRentStart.get(Calendar.DAY_OF_MONTH);
        this.rentStart.set(year, month, day);
    }
    public void setRentEnd(Calendar selectedRentEnd) {
        int year = selectedRentEnd.get(Calendar.YEAR);
        int month = selectedRentEnd.get(Calendar.MONTH);
        int day = selectedRentEnd.get(Calendar.DAY_OF_MONTH);
        this.rentEnd.set(year, month, day);
    }

    public void setTotalPrice (float price, Calendar selectedRentStart, Calendar selectedRentEnd)
    {
        int rentPeriod = calculateRentPeriod(selectedRentStart, selectedRentEnd);
         this.rentPrice = price * rentPeriod;
    }

//    getters

    public String getRentCarVin() {
        return rentCarVin;
    }

    public Calendar getRentStart(){
        return rentStart;
    }
    public Calendar getRentEnd(){
        return rentEnd;
    }
//
    private int calculateRentPeriod(Calendar selectedRentStart, Calendar selectedRentEnd) {
        long rentStartMillis = selectedRentStart.getTimeInMillis();
        long rentEndMillis = selectedRentEnd.getTimeInMillis();
        long millisDiff = Math.abs(rentEndMillis - rentStartMillis);

        return (int) TimeUnit.MILLISECONDS.toDays(millisDiff);
    }

}
