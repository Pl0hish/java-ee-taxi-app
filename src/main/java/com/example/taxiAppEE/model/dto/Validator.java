package com.example.taxiAppEE.model.dto;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    public static Validator instance;
    private static final String EMAIL_REGEX = "[A-z0-9._%+-]+@[A-z0-9.-]+\\.[A-z]{2,6}";

    public static synchronized Validator getInstance() {
        if (instance == null) {
            instance = new Validator();
        }
        return instance;
    }


    public static List<String> validate(Object o) {
        if (o.getClass() == UserDTO.class) {
            return userValidation((UserDTO) o);
        } else if (o.getClass() == OrderDTO.class){
            return orderValidation((OrderDTO) o);
        }

        return new ArrayList<>();
    }

    private static List<String> userValidation(UserDTO userDTO) {
        List<String> list = new ArrayList<>();

        if (userDTO.getFirstName() == null ||
                userDTO.getFirstName().length() < 3 ||
                userDTO.getFirstName().length() > 30) {
            list.add("firstName");
        }

        if (userDTO.getLastName() == null ||
                userDTO.getLastName().length() < 3 ||
                userDTO.getLastName().length() > 30) {
            list.add("lastName");
        }

        if (userDTO.getEmail() == null ||
                !userDTO.getEmail().matches(EMAIL_REGEX)) {
            list.add("email");
        }

        if (userDTO.getPassword() == null ||
                userDTO.getPassword().length() < 3 ||
                userDTO.getPassword().length() > 30) {
            list.add("password");
        }

        return list;
    }

    private static List<String> orderValidation(OrderDTO orderDTO) {
        List<String> list = new ArrayList<>();

        if (orderDTO.getDepartureAddress() == null ||
                orderDTO.getDepartureAddress().length() < 3 ||
                orderDTO.getDepartureAddress().length() > 30) {
            list.add("departureAddress");
        }

        if (orderDTO.getDestinationAddress() == null ||
                orderDTO.getDestinationAddress().length() < 3 ||
                orderDTO.getDestinationAddress().length() > 30) {
            list.add("destinationAddress");
        }

        if (orderDTO.getPassengers() == null ||
                orderDTO.getPassengers() > 7 ||
                orderDTO.getPassengers() < 1) {
            list.add("passengers");
        }

        if (orderDTO.getCategory() == null) {
            list.add("category");
        }

        return list;
    }
}
