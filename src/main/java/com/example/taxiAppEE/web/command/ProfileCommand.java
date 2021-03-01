package com.example.taxiAppEE.web.command;

import com.example.taxiAppEE.exception.UserException;
import com.example.taxiAppEE.model.User;
import com.example.taxiAppEE.service.OrderService;
import com.example.taxiAppEE.service.UserService;
import com.example.taxiAppEE.web.Path;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

import static com.example.taxiAppEE.web.Path.*;

public class ProfileCommand extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, UserException, SQLException {

        User user = UserService.getInstance()
                .findUserByEmail((String) request.getSession()
                        .getAttribute("email"));

        request.setAttribute("user" ,user);
        request.setAttribute("userOrders", OrderService.getInstance()
                .getOrdersByUserId(user.getId()));

        return PAGE_PROFILE;
    }
}
