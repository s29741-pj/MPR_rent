package com.example.carrental;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {
//    initialization for unit test without mockito
//    private CarService carService;
//    private RentService rentService;
//    private RentalStorage rentalStorage;
//    private CustomerStorage customerStorage;
//    private CarStorage carStorage;


    @Captor
    private ArgumentCaptor<Customer> customerArgumentCaptor;

    @Mock
    private Customer customer;

    @InjectMocks
    private CarService carService;


//    do metod zwracających void używamy verify


//    without Mockito tests

//    @BeforeEach
//    public void setUp() {
//        carService = new CarService();
//        rentService = new RentService();
//        rentalStorage = new RentalStorage();
//        customerStorage = new CustomerStorage();
//        carStorage = new CarStorage();
//    }
//
//    @Test
//    void test_checkIfAvailable_whenAvailable() {
//        customerStorage.addCustomer(new Customer(0, "SCFEKBBK1DGD16518", "2024-12-18", "2024-12-23"));
//        carService.checkIfAvailable(rentService, rentalStorage, customerStorage, 0, carStorage);
//        assertEquals(1, rentalStorage.rentalList.size());
//        assertEquals(rentalStorage.rentalList.get(0).getRentCarVin(), customerStorage.customerStorage.get(0).getSelectedCarVin());
//    }
//
//    @Test
//    void test_checkIfAvailable_whenNotAvailable() {
//        customerStorage.addCustomer(new Customer(0, "SCFEKBBK1DGD16518", "2024-12-18", "2024-12-23"));
//        carService.checkIfAvailable(rentService, rentalStorage, customerStorage, 0, carStorage);
//        customerStorage.addCustomer(new Customer(1, "SCFEKBBK1DGD16518", "2024-12-23", "2024-12-25"));
//        carService.checkIfAvailable(rentService, rentalStorage, customerStorage, 1, carStorage);
//
//        assertEquals(1, rentalStorage.rentalList.size());
//        assertEquals(rentalStorage.rentalList.get(0).getRentCarVin(), customerStorage.customerStorage.get(0).getSelectedCarVin());
//    }


}
