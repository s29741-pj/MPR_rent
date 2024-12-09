package com.example.carrental;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class RentalStorageTest {
    private RentalStorage rentalStorage;
    private RentService rentService;
    private CustomerStorage customerStorage;
    private CarService carService;
    private CarStorage carStorage;

    @BeforeEach
    public void setUp() {
        rentalStorage = new RentalStorage();
        rentService = new RentService();
        customerStorage = new CustomerStorage();
        carService = new CarService();
        carStorage = new CarStorage();
    }

    @Test
    void rentalStorageTest_CarAvailable() {
        customerStorage.addCustomer(new Customer(0, "SCFEKBBK1DGD16518", "2024-12-18", "2024-12-23"));
        carService.checkIfAvailable(rentService, rentalStorage, customerStorage, 0, carStorage);
        customerStorage.addCustomer(new Customer(1, "SCFEKBBK1DGD16518", "2024-12-24", "2024-12-25"));
        carService.checkIfAvailable(rentService, rentalStorage, customerStorage, 1, carStorage);

        assertTrue(rentalStorage.checkIfAvailable(customerStorage, 1));
    }

    @Test
    void rentalStorageTest_CarNotAvailable() {
        customerStorage.addCustomer(new Customer(0, "SCFEKBBK1DGD16518", "2024-12-18", "2024-12-23"));
        carService.checkIfAvailable(rentService, rentalStorage, customerStorage, 0, carStorage);
        customerStorage.addCustomer(new Customer(1, "SCFEKBBK1DGD16518", "2024-12-23", "2024-12-25"));
        carService.checkIfAvailable(rentService, rentalStorage, customerStorage, 1, carStorage);

        assertFalse(rentalStorage.checkIfAvailable(customerStorage, 1));
    }

//    tests for case from 30.11

    @Test
    void rentalStorageTest_CarNotAvailableJune() {
        customerStorage.addCustomer(new Customer(0, "SCFEKBBK1DGD16518", "2025-06-15", "2025-06-20"));
        carService.checkIfAvailable(rentService, rentalStorage, customerStorage, 0, carStorage);
        customerStorage.addCustomer(new Customer(1, "SCFEKBBK1DGD16518", "2025-06-01", "2025-06-16"));
        carService.checkIfAvailable(rentService, rentalStorage, customerStorage, 1, carStorage);
        customerStorage.addCustomer(new Customer(2, "SCFEKBBK1DGD16518", "2025-06-17", "2025-06-22"));
        carService.checkIfAvailable(rentService, rentalStorage, customerStorage, 2, carStorage);
        customerStorage.addCustomer(new Customer(3, "SCFEKBBK1DGD16518", "2025-06-16", "2025-06-18"));
        carService.checkIfAvailable(rentService, rentalStorage, customerStorage, 3, carStorage);
        customerStorage.addCustomer(new Customer(1, "SCFEKBBK1DGD16518", "2025-06-14", "2025-06-21"));
        carService.checkIfAvailable(rentService, rentalStorage, customerStorage, 4, carStorage);

        assertFalse(rentalStorage.checkIfAvailable(customerStorage, 1));
        assertFalse(rentalStorage.checkIfAvailable(customerStorage, 2));
        assertFalse(rentalStorage.checkIfAvailable(customerStorage, 3));
        assertFalse(rentalStorage.checkIfAvailable(customerStorage, 4));
    }

    @Test
    void rentalStorageTest_CarAvailableJune() {
        customerStorage.addCustomer(new Customer(0, "SCFEKBBK1DGD16518", "2025-06-15", "2025-06-20"));
        carService.checkIfAvailable(rentService, rentalStorage, customerStorage, 0, carStorage);
        customerStorage.addCustomer(new Customer(1, "SCFEKBBK1DGD16518", "2025-06-09", "2025-06-11"));
        carService.checkIfAvailable(rentService, rentalStorage, customerStorage, 1, carStorage);
        customerStorage.addCustomer(new Customer(2, "SCFEKBBK1DGD16518", "2025-06-21", "2025-06-24"));
        carService.checkIfAvailable(rentService, rentalStorage, customerStorage, 2, carStorage);
        customerStorage.addCustomer(new Customer(3, "SCFEKBBK1DGD16518", "2025-06-28", "2025-06-27"));
        carService.checkIfAvailable(rentService, rentalStorage, customerStorage, 3, carStorage);

        assertTrue(rentalStorage.checkIfAvailable(customerStorage, 1));
        assertTrue(rentalStorage.checkIfAvailable(customerStorage, 2));
        assertTrue(rentalStorage.checkIfAvailable(customerStorage, 3));
    }


}
