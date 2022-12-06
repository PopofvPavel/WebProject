package ru.rsreu.control.commands;

import ru.rsreu.datalayer.data.Request;
import ru.rsreu.datalayer.data.RequestStatus;
import ru.rsreu.datalayer.data.RequestType;
import ru.rsreu.datalayer.handlers.CaptainActionHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void init() {

    }
//http://localhost:8080/demo_war_exploded/HelloServlet?command=DeleteUser&id=22&method=post
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Command command = this.getCommand(request);
        System.out.println("In doGet meth");
        command.init(this.getServletContext(), request, response);
        command.execute();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Command command = this.getCommand(request);
        System.out.println("In doPost meth");
        command.init(this.getServletContext(), request, response);
        command.send();
    }

    private void sendNewRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("buttonNewRequest") != null) {
            CaptainActionHandler.sendRequest(new Request(5, RequestType.ARRIVAL, RequestStatus.IN_CONSIDERATON, 3));
            System.out.println("registered new request");
        }
        request.getRequestDispatcher("/WEB-INF/some-result.jsp").forward(request, response);
    }

    private Command getCommand(HttpServletRequest request)  {
        //String path = String.format("ru.rsreu.control.commands.%sCommand", request.getPathInfo().substring(1));
        String path = String.format("ru.rsreu.control.commands.%sCommand", request.getParameter("command"));
        System.out.println("Path = " + path);
        Class<?> type = null;
        try {
            type = Class.forName(path);
            System.out.println("type = " + type);
        } catch (ClassNotFoundException e) {
            System.err.println("Error in Class.forName");
        }
        try {
            return type.asSubclass(Command.class).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            System.err.println("Error in returning type class");
        }
        return null;///change later
    }


    public void destroy() {
    }
}