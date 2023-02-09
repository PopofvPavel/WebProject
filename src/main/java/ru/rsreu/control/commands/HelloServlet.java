package ru.rsreu.control.commands;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;
import ru.rsreu.datalayer.DAO.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

/**
 * Main servlet which receives commands and executes them
 */
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    //http://localhost:8080/demo_war_exploded/admin-page.jsp?

    /**
     * Initializes servlet context with DAO objects and resourcer
     */
    public void init() {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        UsersDAO usersDAO = factory.getUserDAO();
        PiersDAO piersDAO = factory.getPiersDAO();
        RequestsDAO requestsDAO = factory.getRequestsDAO();
        ShipsDAO shipsDAO = factory.getShipsDAO();
        WorkersDAO workersDAO = factory.getWorkersDAO();

        this.getServletContext().setAttribute("userDAO", usersDAO);
        this.getServletContext().setAttribute("piersDAO", piersDAO);
        this.getServletContext().setAttribute("requestsDAO", requestsDAO);
        this.getServletContext().setAttribute("shipsDAO", shipsDAO);
        this.getServletContext().setAttribute("workersDAO", workersDAO);

        //Resourcer resourcer = ProjectResourcer.getInstance();
        Locale.setDefault(Locale.US);
        Resourcer resourcer = ProjectResourcer.getInstance();
        this.getServletContext().setAttribute("resourcer", resourcer);
        System.out.println(resourcer.getString("db.url"));



        // getServletContext().setSessionTimeout(15);
    }

    //http://localhost:8080/demo_war_exploded/HelloServlet?command=DeleteUser&id=22&method=post

    /**
     * Receives doGet commands and executed them
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Command command = this.getCommand(request);
        System.out.println("In doGet meth");
        command.init(this.getServletContext(), request, response);
        command.execute();
    }

    /**
     * Receives doPost commands and sends them
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Command command = this.getCommand(request);
        System.out.println("In doPost meth");
        command.init(this.getServletContext(), request, response);
        command.send();
    }


    /**
     * Determines command from request parameter and return class of send command
     * @param request
     * @return
     */
    private Command getCommand(HttpServletRequest request) {
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