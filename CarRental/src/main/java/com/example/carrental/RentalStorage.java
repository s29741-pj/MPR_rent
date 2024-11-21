package com.example.carrental;

import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

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

    private Rent getSelectedRentalDates(String vin) {
        for (Rent rent : rentalList) {
            if (rent.getRentCarVin().equals(vin)) {
                return rent;
            }
        }
        throw new IllegalArgumentException("Car with VIN " + vin + " not found.");
    }

    private boolean checkDateRentStart(Customer customer) {
        return customer.getSelectedRentStart().after(getSelectedRentalDates(customer.getSelectedCarVin()).getRentEnd());
    }

    private boolean checkDateRentEnd(Customer customer) {
        return customer.getSelectedRentEnd().before(getSelectedRentalDates(customer.getSelectedCarVin()).getRentStart()) && customer.getSelectedRentEnd().after(Calendar.getInstance(TimeZone.getTimeZone("Europe/Warsaw")));
    }

    private boolean checkDateStartOffRentalList(Customer customer) {
        return  customer.getSelectedRentStart().after(Calendar.getInstance(TimeZone.getTimeZone("Europe/Warsaw")));
    }

    private void printMinRentDate() {
        System.out.print(Calendar.getInstance(TimeZone.getTimeZone("Europe/Warsaw")).get(Calendar.DAY_OF_MONTH) + "/");
        System.out.print(Calendar.getInstance(TimeZone.getTimeZone("Europe/Warsaw")).get(Calendar.MONTH)+1 + "/");
        System.out.println(Calendar.getInstance(TimeZone.getTimeZone("Europe/Warsaw")).get(Calendar.YEAR));
    }

    private void printRentEndDate(Customer customer) {
        System.out.print(getSelectedRentalDates(customer.getSelectedCarVin()).getRentEnd().get(Calendar.DAY_OF_MONTH) + "/");
        System.out.print(customer.getSelectedRentEnd().get(Calendar.MONTH) + "/");
        System.out.println(customer.getSelectedRentEnd().get(Calendar.YEAR));
    }

    private void printCustomerCarDates(Customer customer) {
        System.out.print(customer.getSelectedRentStart().get(Calendar.DAY_OF_MONTH) + "/");
        System.out.print(customer.getSelectedRentStart().get(Calendar.MONTH) + "/");
        System.out.println(customer.getSelectedRentStart().get(Calendar.YEAR));
    }


    private boolean checkDateEndOffRentalList(Customer customer) {
        return  customer.getSelectedRentStart().after(Calendar.getInstance(TimeZone.getTimeZone("Europe/Warsaw")));
    }

    private boolean rentDatesPreCheck(Customer customer) {
        return checkDateStartOffRentalList(customer) && checkDateEndOffRentalList(customer);
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
}
