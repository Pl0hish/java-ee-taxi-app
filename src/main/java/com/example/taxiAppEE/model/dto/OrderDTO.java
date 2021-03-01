package com.example.taxiAppEE.model.dto;

import com.example.taxiAppEE.model.Car;
import lombok.*;

import java.util.Random;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderDTO {

    private String departureAddress;
    private String destinationAddress;
    private Integer passengers;
    private Car.Category category;
    @Setter(AccessLevel.NONE)
    private int distance;

    public OrderDTO(String departureAddress,
                    String destinationAddress,
                    Integer passengers,
                    Car.Category category,
                    int distance) {
        this.departureAddress=departureAddress;
        this.destinationAddress=destinationAddress;
        this.passengers=passengers;
        this.category=category;
        this.distance=distance;
    }

    public double setDistance() {
        return this.distance=new Random().nextInt(30 - 2 + 1) + 2;
    }

    public double getPrice() {
        return distance * category.getKmPrice();
    }

}
