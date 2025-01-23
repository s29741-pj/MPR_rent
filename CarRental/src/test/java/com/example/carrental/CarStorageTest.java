//package com.example.carrental;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//
//public class CarStorageTest {
//    private CarStorage carStorage;
//
//    @BeforeEach
//    public void setUp() {
//        carStorage = new CarStorage();
//    }
//
//    @Test
//    void test_getPriceVinCorrect() {
//        assertEquals(2200, carStorage.getPrice("SCFEKBBK1DGD16518"));
//
//    }
//
//    @Test
//    void test_getPriceVinIncorrect() {
//        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,() -> {carStorage.getPrice("1234");});
//        assertEquals("Car with VIN 1234 not found.", e.getMessage());
//    }
//
//
//}
