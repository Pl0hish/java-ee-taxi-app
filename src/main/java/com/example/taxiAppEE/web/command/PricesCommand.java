package com.example.taxiAppEE.web.command;

import com.example.taxiAppEE.exception.UserException;
import com.example.taxiAppEE.model.Car;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static com.example.taxiAppEE.web.Path.PAGE_PRICES;

public class PricesCommand extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, UserException, SQLException {

        request.setAttribute("categories", Car.Category.values());
        return PAGE_PRICES;
    }
}