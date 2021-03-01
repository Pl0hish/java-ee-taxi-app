package com.example.taxiAppEE.web.command;

import com.example.taxiAppEE.model.Car;
import com.example.taxiAppEE.model.dto.OrderDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.example.taxiAppEE.web.Path.PAGE_MAKE_ORDER;

public class MakeOrderGetCommand extends Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        OrderDTO orderDTO = new OrderDTO();
        request.setAttribute("categories", Car.Category.values());
        orderDTO.setPassengers(1);

        return PAGE_MAKE_ORDER;
    }
}
