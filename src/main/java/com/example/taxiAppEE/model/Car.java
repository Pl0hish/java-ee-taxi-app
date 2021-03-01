package com.example.taxiAppEE.model;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Car {

    private int id;
    private int seats;
    private String driver;
    private int kmPrice;
    private Category category;
    private Status status;

    public Car(int seats,
               Category category,
               String driver) {
        this.seats=seats;
        this.category=category;
        this.driver=driver;
        this.status=Status.AVAILABLE;
        this.kmPrice=category.getKmPrice();
    }

    public enum Category {
        PREMIUM(20),
        BUSINESS(15),
        COMFORT(10),
        STANDARD(5),
        ECONOMY(1);

        private final int kmPrice;

        Category(int kmPrice) {
            this.kmPrice=kmPrice;
        }

        public int getKmPrice() {
            return kmPrice;
        }

        public String getCategory() {
            return this.toString();
        }

        public static Category getCategory(String category) {
            switch (category) {
                case "PREMIUM":
                    return PREMIUM;
                case "BUSINESS":
                    return BUSINESS;
                case "COMFORT":
                    return COMFORT;
                case "STANDARD":
                    return STANDARD;
                default:
                    return ECONOMY;
            }
        }

    }

    public enum Status {
        AVAILABLE,
        ACTIVE,
        OFFLINE;

        public static Status getStatus(String status) {
            switch (status) {
                case "AVAILABLE":
                    return AVAILABLE;
                case "ACTIVE":
                    return ACTIVE;
                default:
                    return OFFLINE;
            }
        }
    }

    public void setCategory(String category) {
        this.category=Category.getCategory(category);
    }

    public void setStatus(String status) {
        this.status=Status.getStatus(status);
    }

    public void setStatus(Status status) {
        this.status=status;
    }
}