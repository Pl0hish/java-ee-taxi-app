package com.example.taxiAppEE.web.command;

import com.example.taxiAppEE.model.Car;
import com.example.taxiAppEE.model.Order;
import com.example.taxiAppEE.model.dto.OrderDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.example.taxiAppEE.web.Path.PAGE_CONFIRMATION;

public class ConfirmationCommand extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {


        Order order = new Order();

        order.setDepartureAddress((String) request.getAttribute("departureAddress"));


        order.setDestinationAddress(request.getParameter("destinationAddress"));
        order.setPassengers(Integer.parseInt(request.getParameter("passengers")));
//        order.setCarCategory(request.getParameter("category"));
//        order.setDate(request.getParameter("date"));
//        order.setCarId(request.getParameter("carId"));
//        order.setDistance(request.getParameter("distance"));
//        order.setUserId(request.getParameter("userId"));
//        order.setPrice(request.getParameter("price"));

        return PAGE_CONFIRMATION;
    }
}
