package ru.rsreu.control.commands;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutCommand extends Command {
    @Override
    public void init(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
        super.init(context, request, response);
    }

    @Override
    public void send() throws IOException {
        request.getSession().invalidate();
        System.out.println("session deleted");
        response.sendRedirect("login.jsp");
        //forward("/login.jsp");
        //response.sendRedirect("/login.jsp");
    }
}
