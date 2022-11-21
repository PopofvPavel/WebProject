package com.example.demo;

import ru.rsreu.datalayer.data.User;
import ru.rsreu.datalayer.handlers.AdminActionHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private String gg, wp, gt;

    public void init() {
        message = "1";

//        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
//        UsersDAO usersDAO = factory.getUserDAO();
//        List<User> usersTable = usersDAO.getRequest();
//
//        AdminActionDAO adminActionDAO = factory.getUsersInfoDAO();
//        List<UserInfo> usersInfoTable = adminActionDAO.getUsersInfoTable();

        wp = AdminActionHandler.getUsersTable();
        gg = AdminActionHandler.getUsersInfoTable();

        //adminActionDAO.registerNewUser(new User(7,3,"DISP2", "DISP2", 0,0));
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        response.setContentType("text/html");
//        //main
//
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + gg + "</h1>");
//        out.println("<h1>" + wp + "</h1>");
//        out.println("</body></html>");

        //registerNewUserRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        processRequest(request, response);
//        registerNewUserRequest(request, response);



        if (request.getParameter("button1") != null) {
            AdminActionHandler.registerNewUser(new User(9,1,"ADMIN","ADMIN",0,0));
            System.out.println("easy gg wp");
        } else if (request.getParameter("button2") != null) {
            AdminActionHandler.registerNewUser(new User(9,2,"MODER","MODER",0,0));

        } else if (request.getParameter("button3") != null) {
            AdminActionHandler.registerNewUser(new User(9,3,"CAPITAN","CAPITAN",0,0));
        } else {
            // ???
        }

        request.getRequestDispatcher("/WEB-INF/some-result.jsp").forward(request, response);
    }


    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GregorianCalendar gc = new GregorianCalendar();
        String timeJsp = request.getParameter("time");
        float delta = ((float) (gc.getTimeInMillis() - Long.parseLong(timeJsp)))/1000;
        request.setAttribute("res", delta);
        request.getRequestDispatcher("/jsp/result.jsp").forward(request,response);

    }

    private void registerNewUserRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String radio = request.getParameter("usertype");

        if ("Admin".equals(radio)) {
            AdminActionHandler.registerNewUser(new User(11,1,"ADMIN","ADMIN",0,0));
            System.out.println("success");
        } else if ("Moder".equals(radio)) {
            AdminActionHandler.registerNewUser(new User(11,2,"MODER","MODER",0,0));
            System.out.println("success");
        } else if ("User".equals(radio)) {
            AdminActionHandler.registerNewUser(new User(11,3,"CAPITAN","CAPITAN",0,0));
            System.out.println("success");
        } else {
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>" + "user ne vibran" + "</h1>");
            out.println("</body></html>");
        }

        request.getRequestDispatcher("admin-page.jsp").forward(request, response);
    }

    public void destroy() {
    }
}