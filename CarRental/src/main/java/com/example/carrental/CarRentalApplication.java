package com.example.carrental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class CarRentalApplication {
    private final CarService carService;
    private final CarStorage carStorage;
    private final RentService rentService;
    private final RentalStorage rentalStorage;

    public CarRentalApplication(CarService carService, CarStorage carStorage, RentService rentService, RentalStorage rentalStorage) {
        this.carService = carService;
        this.carStorage = carStorage;
        this.rentService = rentService;
        this.rentalStorage = rentalStorage;
        runApp();
    }

    public void runApp(){
        carService.addCustomer(new Customer(0,"SCFEKBBK1DGD16518","2024/11/23","2023/11/25"));
        carService.checkIfAvailable(rentService, rentalStorage,carService.getCustomer(0), carStorage, 0);


        carService.addCustomer(new Customer(1,"SCFEKBBK1DGD16518","2024/11/23","2024/11/25"));
        carService.checkIfAvailable(rentService, rentalStorage, carService.getCustomer(1),  carStorage, 1);

//        carService.addCustomer(new Customer(2,"SCFEKBBK1DGD16518","2024/10/23","2023/10/25"));
//        carService.checkIfAvailable(rentService, rentalStorage,carService.getCustomer(2), carStorage, 2);
//
//        carService.addCustomer(new Customer(3,"SCFEKBBK","2024/11/23","2023/11/25"));
//        carService.checkIfAvailable(rentService, rentalStorage,carService.getCustomer(3),  carStorage, 3);


    }

    public static void main(String[] args) {
        SpringApplication.run(CarRentalApplication.class, args);
        System.exit(0);
    }

}
