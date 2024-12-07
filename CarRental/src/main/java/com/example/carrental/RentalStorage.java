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

    public boolean checkIfAvailable(CustomerStorage customerStorage, int customerID) {
        if (rentalList.isEmpty() || !checkIfCarOnRentalList(customerStorage.getCustomer(customerID).getSelectedCarVin())) {
            if(rentDatesPreCheck(customerStorage, customerID)){
                return true;
            }else {
                System.out.println("Wrong date provided:");
                printCustomerCarDates(customerStorage , customerID);
                System.out.println("Rents can be made only after:");
                printMinRentDate();
                return false;
            }
        }else if(checkDateRentStart(customerStorage, customerID) && checkDateRentEnd(customerStorage, customerID)) {
            return true;
        }else {
            System.out.println("Car with VIN " + customerStorage.getCustomer(customerID).getSelectedCarVin() + " is not available until:");
            printRentEndDate(customerStorage, customerID);
            return false;
        }
    }


    private boolean checkIfCarOnRentalList(String vin) {
        for (Rent rent : rentalList) {
            if (rent.getRentCarVin().equals(vin)) {
                return true;
            }
        }
        return false;
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

    private boolean checkDateRentStart(CustomerStorage customerStorage, int customerID) {
        return customerStorage.getCustomer(customerID).getSelectedRentStart().isAfter(getSelectedRentalDates(customerStorage.getCustomer(customerID).getSelectedCarVin()).getRentEnd());
    }

    private boolean checkDateRentEnd(CustomerStorage customerStorage, int customerID) {
        return customerStorage.getCustomer(customerID).getSelectedRentEnd().isAfter(customerStorage.getCustomer(customerID).getSelectedRentStart()) && customerStorage.getCustomer(customerID).getSelectedRentEnd().isAfter(LocalDate.now());
    }


    private boolean checkDateStartOffRentalList(CustomerStorage customerStorage, int customerID) {
//        System.out.println("date start off Rental List");
//        System.out.println(customer.getSelectedRentStart().isAfter(LocalDate.now()) || customer.getSelectedRentStart().isEqual(LocalDate.now()));
        return customerStorage.getCustomer(customerID).getSelectedRentStart().isAfter(LocalDate.now()) || customerStorage.getCustomer(customerID).getSelectedRentStart().isEqual(LocalDate.now());
    }

    private boolean checkDateEndOffRentalList(CustomerStorage customerStorage, int customerID) {
//        System.out.println("date end off Rental List");
//        System.out.println(customer.getSelectedRentEnd().isAfter(customer.getSelectedRentStart()));
        return customerStorage.getCustomer(customerID).getSelectedRentEnd().isAfter(customerStorage.getCustomer(customerID).getSelectedRentStart());
    }

    private boolean rentDatesPreCheck(CustomerStorage customerStorage , int customerID) {
//        System.out.println("date pre check");
//        System.out.println(checkDateStartOffRentalList(customer) && checkDateEndOffRentalList(customer));
        return checkDateStartOffRentalList(customerStorage, customerID ) && checkDateEndOffRentalList(customerStorage, customerID);
    }

//    date printers
    private void printMinRentDate() {
        System.out.println(LocalDate.now());
    }

    private void printRentEndDate(CustomerStorage customerStorage, int customerID) {
        System.out.print(getSelectedRentalDates(customerStorage.getCustomer(customerID).getSelectedCarVin()).getRentEnd().getYear()+ "-");
        System.out.print(customerStorage.getCustomer(customerID).getSelectedRentEnd().getMonthValue() + "-");
        System.out.println(customerStorage.getCustomer(customerID).getSelectedRentEnd().getDayOfMonth());
    }

    private void printCustomerCarDates(CustomerStorage customerStorage, int customerID) {
        System.out.print(customerStorage.getCustomer(customerID).getSelectedRentStart().getYear()+ "-");
        System.out.print(customerStorage.getCustomer(customerID).getSelectedRentStart().getMonthValue() + "-");
        System.out.println(customerStorage.getCustomer(customerID).getSelectedRentStart().getDayOfMonth());
    }
}
