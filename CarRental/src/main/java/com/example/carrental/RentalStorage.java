package com.example.carrental;

import org.springframework.stereotype.Component;


import java.time.LocalDate;
import java.util.ArrayList;


@Component
public class RentalStorage {
    public ArrayList<Rent> rentalList = new ArrayList<>();

    public void addNewRental(Rent rent) {
        rentalList.add(rent);
    }

    public ArrayList<Rent> getRentalList() {
        return rentalList;
    }


}
