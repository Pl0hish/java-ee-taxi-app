package com.example.taxiAppEE.web;

import com.example.taxiAppEE.web.command.Command;
import com.example.taxiAppEE.web.command.CommandContainer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Controller extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    /**
     * Main method of this controller.
     */
    private void process(HttpServletRequest request,
                         HttpServletResponse response) throws IOException, ServletException {

        if (request.getParameter("redirect") != null) {

            if (request.getParameter("redirect").equals("/confirmationPage")) {
                request.getSession().setAttribute("confirmationOrder", request.getAttribute("confirmationOrder"));
            }

            response.sendRedirect(request.getParameter("redirect"));
            return;
        }

        String commandName = request.getRequestURI().replaceFirst("/", "");
        Command command = CommandContainer.get(commandName);
        String forward = Path.PAGE_ERROR_PAGE;

        try {
            forward = command.execute(request, response);
        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex.getMessage());
        }


        request.getRequestDispatcher(forward).forward(request, response);
    }
}