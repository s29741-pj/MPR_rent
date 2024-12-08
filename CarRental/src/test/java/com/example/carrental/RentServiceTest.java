package com.example.carrental;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class RentServiceTest {
    private RentService rentService;
    private RentalStorage rentalStorage;
    private CustomerStorage customerStorage;
    private CarService carService;
    private CarStorage carStorage;

    @BeforeEach
    public void setUp(){
        rentService = new RentService();
        rentalStorage = new RentalStorage();
        customerStorage = new CustomerStorage();
        carService = new CarService();
        carStorage = new CarStorage();
    }

    @Test
    void testUploadNewRent_DirectTrue() {
        customerStorage.addCustomer(new Customer (0,"SCFEKBBK1DGD16518","2024-12-18","2024-12-23"));
        rentService.uploadNewRent(true,rentalStorage,customerStorage,0);
        assertEquals(rentalStorage.rentalList.get(0).getRentCarVin(), customerStorage.getCustomer(0).getSelectedCarVin());
    };

    @Test
    void testUploadNewRent_DirectFalse() {
        customerStorage.addCustomer(new Customer (0,"SCFEKBBK1DGD16518","2024-12-18","2024-12-23"));
        rentService.uploadNewRent(false,rentalStorage,customerStorage,0);
        assertEquals(0,rentalStorage.rentalList.size());
    };

    @Test
    void testUploadNewRent_viaCarService() {
        customerStorage.addCustomer(new Customer (0,"SCFEKBBK1DGD16518","2024-12-18","2024-12-23"));
        carService.checkIfAvailable(rentService,rentalStorage,customerStorage,0,carStorage);
        assertEquals(rentalStorage.rentalList.get(0).getRentCarVin(), customerStorage.getCustomer(0).getSelectedCarVin());
    }

}
