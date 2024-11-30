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

    private boolean checkIfCarOnRentalList(String vin) {
        for (Rent rent : rentalList) {
            if (rent.getRentCarVin().equals(vin)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIfAvailable(Customer customer) {
        if (rentalList.isEmpty() || !checkIfCarOnRentalList(customer.getSelectedCarVin())) {
            if(rentDatesPreCheck(customer)){
                return true;
            }else {
                System.out.println("Wrong date provided:");
                printCustomerCarDates(customer);
                System.out.println("Rents can be made only after:");
                printMinRentDate();
                return false;
            }
        }else if(checkDateRentStart(customer) && checkDateRentEnd(customer)) {
            return true;
        }else {
            System.out.println("Car with VIN " + customer.getSelectedCarVin() + " is not available until:");
            printRentEndDate(customer);
            return false;
        }
    }

//    date getters
    private Rent getSelectedRentalDates(String vin) {
        for (Rent rent : rentalList) {
            if (rent.getRentCarVin().equals(vin)) {
                return rent;
            }
        }
        throw new IllegalArgumentException("Car with VIN " + vin + " not found.");
    }

    private boolean checkDateRentStart(Customer customer) {
        return customer.getSelectedRentStart().isAfter(getSelectedRentalDates(customer.getSelectedCarVin()).getRentEnd());
    }

    private boolean checkDateRentEnd(Customer customer) {
        return customer.getSelectedRentEnd().isAfter(customer.getSelectedRentStart()) && customer.getSelectedRentEnd().isAfter(LocalDate.now());
    }


    private boolean checkDateStartOffRentalList(Customer customer) {
//        System.out.println("date start off Rental List");
//        System.out.println(customer.getSelectedRentStart().isAfter(LocalDate.now()) || customer.getSelectedRentStart().isEqual(LocalDate.now()));
        return customer.getSelectedRentStart().isAfter(LocalDate.now()) || customer.getSelectedRentStart().isEqual(LocalDate.now());
    }

    private boolean checkDateEndOffRentalList(Customer customer) {
//        System.out.println("date end off Rental List");
//        System.out.println(customer.getSelectedRentEnd().isAfter(customer.getSelectedRentStart()));
        return customer.getSelectedRentEnd().isAfter(customer.getSelectedRentStart());
    }

    private boolean rentDatesPreCheck(Customer customer) {
//        System.out.println("date pre check");
//        System.out.println(checkDateStartOffRentalList(customer) && checkDateEndOffRentalList(customer));
        return checkDateStartOffRentalList(customer) && checkDateEndOffRentalList(customer);
    }

//    date printers
    private void printMinRentDate() {
        System.out.println(LocalDate.now());
    }

    private void printRentEndDate(Customer customer) {
        System.out.print(getSelectedRentalDates(customer.getSelectedCarVin()).getRentEnd().getYear()+ "-");
        System.out.print(customer.getSelectedRentEnd().getMonthValue() + "-");
        System.out.println(customer.getSelectedRentEnd().getDayOfMonth());
    }

    private void printCustomerCarDates(Customer customer) {
        System.out.print(customer.getSelectedRentStart().getYear()+ "-");
        System.out.print(customer.getSelectedRentStart().getMonthValue() + "-");
        System.out.println(customer.getSelectedRentStart().getDayOfMonth());
    }
}
