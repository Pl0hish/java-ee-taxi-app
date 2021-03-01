package com.example.taxiAppEE.web.command;

import com.example.taxiAppEE.exception.UserException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import static com.example.taxiAppEE.web.Path.*;

public class SuccessCommand extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, UserException, SQLException {

        request.setAttribute("timeToWait", new Random().nextInt(25 - 1 + 1) + 1);

        return PAGE_SUCCESS;
    }
}