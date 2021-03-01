package com.example.taxiAppEE.web.command;

import com.example.taxiAppEE.exception.UserException;
import com.example.taxiAppEE.model.dto.UserDTO;
import com.example.taxiAppEE.model.dto.Validator;
import com.example.taxiAppEE.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static com.example.taxiAppEE.web.Path.PAGE_REGISTRATION;
import static com.example.taxiAppEE.web.Path.REDIRECT_PAGE_LOGIN;

public class RegistrationPostCommand extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, UserException, SQLException {

        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(request.getParameter("firstName"));
        userDTO.setLastName(request.getParameter("lastName"));
        userDTO.setEmail(request.getParameter("email"));
        userDTO.setPassword(request.getParameter("password"));
        request.setAttribute("userDto", userDTO);

        List<String> fields = Validator.validate(userDTO);
        if (fields.size() > 0) {
            request.setAttribute("fields", fields);
            return PAGE_REGISTRATION;
        }

        UserService userService = UserService.getInstance();
        try {
            userService.create(userDTO);
        } catch (Exception e) {
            request.setAttribute("exception", userDTO.getEmail());
            return PAGE_REGISTRATION;
        }

        return REDIRECT_PAGE_LOGIN;
    }
}