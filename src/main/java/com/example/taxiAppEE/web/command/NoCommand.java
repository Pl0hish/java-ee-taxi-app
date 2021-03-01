package com.example.taxiAppEE.web.command;

import com.example.taxiAppEE.web.Path;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoCommand extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String errorMessage = "No such command";
        request.setAttribute("errorMessage", errorMessage);

        return Path.PAGE_ERROR_PAGE;
    }

}
