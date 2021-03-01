package com.example.taxiAppEE.model;

import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order {

    private int id;
    private String departureAddress;
    private String destinationAddress;
    private double price;
    private int passengers;
    private int distance;
    @Getter(AccessLevel.NONE)
    private LocalDateTime date;
    private int carId;
    private int userId;
    @Getter(AccessLevel.NONE)
    private Car.Category carCategory;

    public Order(String departureAddress,
                 String destinationAddress,
                 int passengers,
                 int distance,
                 double price,
                 double spentMoney,
                 int carId,
                 int userId,
                 Car.Category category) {
        this.departureAddress = departureAddress;
        this.destinationAddress = destinationAddress;
        this.passengers = passengers;
        this.carId = carId;
        this.userId = userId;
        this.date = LocalDateTime.now();
        this.distance = distance;
        this.price = (spentMoney > 1000 ? 0.20 : 1)  * price;
        this.carCategory = category;
    }

    public String  getCarCategory() {
        return carCategory.toString();
    }

    public Timestamp getDate() {
        return Timestamp.valueOf(date.withNano(0));
    }

}
