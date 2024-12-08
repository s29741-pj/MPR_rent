package com.example.carrental;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CustomerStorageTest {
    private CustomerStorage customerStorage;

    @BeforeEach
    public void setUp(){
        customerStorage = new CustomerStorage();
    }

    @Test
    void addNewCustomer(){
        customerStorage.addCustomer(new Customer (0,"SCFEKBBK1DGD16518","2024-12-18","2024-12-23"));
        assertEquals(customerStorage.getCustomer(0).getSelectedCarVin(), "SCFEKBBK1DGD16518");
    }




}
