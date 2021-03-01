package com.example.taxiAppEE.web.command;

import com.example.taxiAppEE.dao.UserDao;
import com.example.taxiAppEE.exception.UserException;
import com.example.taxiAppEE.model.Role;
import com.example.taxiAppEE.model.User;
import com.example.taxiAppEE.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

import static com.example.taxiAppEE.web.Path.*;

public class LoginPostCommand extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, UserException, SQLException {

        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserService userService = UserService.getInstance();
        User user;

        try {
            user = userService.findUserByEmail(email);
        } catch (Exception e) {
            request.setAttribute("exception", true);
            return PAGE_LOGIN;
        }

        if (!password.equals(user.getPassword())) {
            request.setAttribute("exception", true);
            return PAGE_LOGIN;
        }

        String userRole = user.getRole().toString();

        session.setAttribute("user", user);
        session.setAttribute("email", email);
        session.setAttribute("userRole", userRole);

        return REDIRECT_PAGE_MAIN;
    }
}