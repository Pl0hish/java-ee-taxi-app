package com.example.taxiAppEE.web.command;

import com.example.taxiAppEE.exception.CarException;
import com.example.taxiAppEE.exception.OrderException;
import com.example.taxiAppEE.exception.UserException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public abstract class Command {

    /**
     * Execution method for command.
     *
     * @return Address to go once the command is executed.
     */
    public abstract String execute(HttpServletRequest request,
                                   HttpServletResponse response) throws IOException, ServletException, UserException, CarException, OrderException, SQLException;

    @Override
    public final String toString() {
        return getClass().getSimpleName();
    }
}