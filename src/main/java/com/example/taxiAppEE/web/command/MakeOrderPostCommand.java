package com.example.taxiAppEE.web.command;

import com.example.taxiAppEE.exception.UserException;
import com.example.taxiAppEE.model.Car;
import com.example.taxiAppEE.model.Order;
import com.example.taxiAppEE.model.User;
import com.example.taxiAppEE.model.dto.OrderDTO;
import com.example.taxiAppEE.model.dto.UserDTO;
import com.example.taxiAppEE.model.dto.Validator;
import com.example.taxiAppEE.service.OrderService;
import com.example.taxiAppEE.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static com.example.taxiAppEE.web.Path.*;

public class MakeOrderPostCommand extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, UserException, SQLException {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setDepartureAddress(request.getParameter("departureAddress"));
        orderDTO.setDestinationAddress(request.getParameter("destinationAddress"));
        orderDTO.setPassengers(Integer.parseInt(request.getParameter("passengers")));
        orderDTO.setCategory(Car.Category.getCategory(request.getParameter("category")));
        request.setAttribute("categories", Car.Category.values());
        request.setAttribute("orderDto", orderDTO);

        List<String> fields = Validator.validate(orderDTO);

        if (fields.size() > 0) {
            request.setAttribute("fields", fields);
            return PAGE_MAKE_ORDER;
        }


        OrderService orderService = OrderService.getInstance();
        User user = (User) request.getSession().getAttribute("user");
        Order order;

        try {
            order = orderService.createOrder(orderDTO, user);
        } catch (Exception e) {
            //TODO SUGGEST ALTERNATIVES PAGE!
            return REDIRECT_PAGE_MAIN;
        }

        request.setAttribute("confirmationOrder", order);

        return REDIRECT_PAGE_CONFIRMATION;
    }
}