package com.example.taxiAppEE.web.command.admin;

import com.example.taxiAppEE.dao.UserDao;
import com.example.taxiAppEE.exception.UserException;
import com.example.taxiAppEE.model.Role;
import com.example.taxiAppEE.model.User;
import com.example.taxiAppEE.web.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

import static com.example.taxiAppEE.web.Path.PAGE_ADMIN;
import static com.example.taxiAppEE.web.Path.PAGE_LOGIN;

public class AdminCommand extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, UserException, SQLException {
        return PAGE_ADMIN;
    }
}