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

        System.out.println("IN ORDER CONFIRMATION POST!!!");
        Order order = (Order) request.getAttribute("confirmationOrder");

        if (order == null) {
            return REDIRECT_PAGE_ERROR;
        }

        OrderService.getInstance().saveOrder(order);

        return REDIRECT_PAGE_SUCCESS;
    }
}
