package ru.rsreu.control.commands;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
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
        try {
            forward("/login.jsp");
        } catch (ServletException e) {
            e.printStackTrace();
        }
        //response.sendRedirect("/login.jsp");
    }
}
