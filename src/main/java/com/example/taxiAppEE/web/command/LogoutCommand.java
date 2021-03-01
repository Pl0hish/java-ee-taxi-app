package com.example.taxiAppEE.web.command;

import com.example.taxiAppEE.exception.UserException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static com.example.taxiAppEE.web.Path.*;

public class LogoutCommand extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, UserException, SQLException {

        request.getSession().setAttribute("user", null);
        request.getSession().setAttribute("userRole", null);

        return REDIRECT_PAGE_LOGIN;
    }
}