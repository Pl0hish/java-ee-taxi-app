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

        Order order = null;
        try {
            order = (Order) request.getSession()
                    .getAttribute("confirmationOrder");
            request.getSession().removeAttribute("confirmationOrder");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        request.setAttribute("confirmationOrder", order);

        return PAGE_CONFIRMATION;
    }
}
