package com.example.carrental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CarRentalApplication {
    private final CarService carService;
    private final CarStorage carStorage;
    private final RentService rentService;
    private final RentalStorage rentalStorage;
    private final  CustomerStorage customerStorage;

    public CarRentalApplication(CarService carService, CarStorage carStorage, RentService rentService, RentalStorage rentalStorage, CustomerStorage customerStorage) {
        this.carService = carService;
        this.carStorage = carStorage;
        this.rentService = rentService;
        this.rentalStorage = rentalStorage;
        this.customerStorage = customerStorage;
        runApp();
    }

    public void runApp(){

        customerStorage.addCustomer(new Customer (0,"SCFEKBBK1DGD16518","2024-12-18","2024-12-23"));
        carService.checkIfAvailable(rentService,rentalStorage, customerStorage,0,carStorage);

        customerStorage.addCustomer(new Customer (1,"SCFEKBBK1DGD16518","2024-12-23","2024-12-25"));
        carService.checkIfAvailable(rentService,rentalStorage, customerStorage,1,carStorage);




    }

    public static void main(String[] args) {
        SpringApplication.run(CarRentalApplication.class, args);
        System.exit(0);
    }

}
