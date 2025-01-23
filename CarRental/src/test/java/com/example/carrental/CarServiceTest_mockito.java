package com.example.carrental;

import com.example.carrental.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

//stop 15.01 add mocked test for RentService

class CarServiceTest_mockito {

    @Mock
    private RentService rentService;

    @Mock
    private RentalStorage rentalStorage;

    @Mock
    private CustomerStorage customerStorage;

    @Mock
    private CarStorage carStorage;

    @InjectMocks
    private CarService carService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testNewRentalCheck_SuccessfulRental() {
        // Arrange
        int customerId = 1;
        Customer mockCustomer = new Customer(customerId, "SCFEKBBK1DGD16518", "2025-01-16", "2025-01-20");

        when(customerStorage.getCustomer(customerId)).thenReturn(mockCustomer);
        when(rentService.checkIfAvailable(customerStorage, customerId, rentalStorage)).thenReturn(true);
        when(carStorage.checkIfExists(mockCustomer.getSelectedCarVin())).thenReturn(true);
        when(carStorage.getPriceByVin(mockCustomer.getSelectedCarVin())).thenReturn(2200.0f);

        // Act
        carService.newRentalCheck(rentService, rentalStorage, customerStorage, customerId, carStorage);

        // Assert
        verify(rentService, times(1)).uploadNewRent(rentalStorage, customerStorage, customerId);
        assertEquals(8800.0f, mockCustomer.getPrice(), "The calculated price should match the expected value.");
    }

    @Test
    void testNewRentalCheck_CarNotAvailable() {
        // Arrange
        int customerId = 1;
        Customer mockCustomer = new Customer(customerId, "INVALID_VIN", "2025-01-16", "2025-01-20");

        when(customerStorage.getCustomer(customerId)).thenReturn(mockCustomer);
        when(rentService.checkIfAvailable(customerStorage, customerId, rentalStorage)).thenReturn(false);

        // Act
        carService.newRentalCheck(rentService, rentalStorage, customerStorage, customerId, carStorage);

        // Assert
        verify(rentService, never()).uploadNewRent(any(), any(), anyInt());
    }

    @Test
    void testNewRentalCheck_CarNotFound() {
        // Arrange
        int customerId = 1;
        Customer mockCustomer = new Customer(customerId, "INVALID_VIN", "2025-01-16", "2025-01-20");

        when(customerStorage.getCustomer(customerId)).thenReturn(mockCustomer);
        when(carStorage.checkIfExists(mockCustomer.getSelectedCarVin())).thenReturn(false);

        // Act
        carService.newRentalCheck(rentService, rentalStorage, customerStorage, customerId, carStorage);

        // Assert
        verify(rentService, never()).uploadNewRent(any(), any(), anyInt());
    }
}
