package com.example.demo;

import ru.rsreu.datalayer.DAO.DAOFactory;
import ru.rsreu.datalayer.DAO.DBType;
import ru.rsreu.datalayer.DAO.UsersDAO;
import ru.rsreu.datalayer.DAO.AdminActionDAO;
import ru.rsreu.datalayer.data.User;
import ru.rsreu.datalayer.data.UserInfo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private String gg,wp,gt;

    public void init() {
        message = "Hello nigga max! Zdarova ept ti na belova sednya poidesh?; vo i kak raz ne hotel idti chet v padlu ;++ya TOJE RPTA" +
                "; OK NIGGA" +
                "nu i ne idem togda zaebis' a kak eto zapustit' KRCH SMOTRI NIDISH GDE KNOPKA ZAPPUSKA TAM ESHO MOLOTOCHEK I SLEVA OT NEGO TAKOI CHELIK BELIY, VOT TAM CODE WITH ME NAZIVAENSYA"
        ;
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        UsersDAO usersDAO = factory.getUserDAO();
        List<User> usersTable = usersDAO.getRequest();

        AdminActionDAO adminActionDAO = factory.getUsersInfoDAO();
        List<UserInfo> usersInfoTable = adminActionDAO.getUsersInfoTable();

        wp = usersInfoTable.toString();
        gg = usersTable.toString();

        adminActionDAO.registerNewUser(new User(7,3,"DISP2", "DISP2", 0,0));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        //main


        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + gg + "</h1>");
        out.println("<h1>" + wp + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}