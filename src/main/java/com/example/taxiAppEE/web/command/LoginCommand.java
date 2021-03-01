package com.example.taxiAppEE.web.command;

import com.example.taxiAppEE.exception.UserException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static com.example.taxiAppEE.web.Path.PAGE_LOGIN;

public class LoginCommand extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, UserException, SQLException {

        return PAGE_LOGIN;
    }
}