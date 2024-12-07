package com.example.carrental;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CarStorageTest {
    private CarService carService;
    private RentService rentService;
    private RentalStorage rentalStorage;
    private CustomerStorage customerStorage;
    private CarStorage carStorage;
    private Customer customer;

    @BeforeEach
    public void setUp() {
        carService = new CarService();
        rentService = new RentService();
        rentalStorage = new RentalStorage();
        customerStorage = new CustomerStorage();
        carStorage = new CarStorage();
    }

    @Test
    void test_getPriceVinCorrect() {
        assertEquals(2200, carStorage.getPrice("SCFEKBBK1DGD16518"));

    }

    @Test
    void test_getPriceVinIncorrect() {
        assertThrows(IllegalArgumentException.class, carStorage.getPrice("1234"));
    }


}
