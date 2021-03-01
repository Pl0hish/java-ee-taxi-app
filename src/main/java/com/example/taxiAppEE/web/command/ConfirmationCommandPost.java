package com.example.taxiAppEE.web.command;

import com.example.taxiAppEE.model.Order;
import com.example.taxiAppEE.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static com.example.taxiAppEE.web.Path.*;

public class ConfirmationCommandPost extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, SQLException {

        Order order;

        try {
            order = new Order(
                    request.getParameter("departureAddress"),
                    request.getParameter("destinationAddress"),
                    Double.parseDouble(request.getParameter("price")),
                    Integer.parseInt(request.getParameter("distance")),
                    Integer.parseInt(request.getParameter("passengers")),
                    Double.parseDouble(request.getParameter("spentMoney")),

            );

        } catch (Exception e) {
            return REDIRECT_PAGE_ERROR;
        }



        OrderService.getInstance().saveOrder(order);

        return REDIRECT_PAGE_SUCCESS;
    }
}
