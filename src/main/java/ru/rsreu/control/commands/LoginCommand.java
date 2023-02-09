package ru.rsreu.control.commands;

import ru.rsreu.datalayer.DAO.UsersDAO;
import ru.rsreu.datalayer.DAO.WorkersDAO;
import ru.rsreu.datalayer.data.Post;
import ru.rsreu.datalayer.data.User;
import ru.rsreu.datalayer.data.Worker;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LoginCommand extends Command {
    //private static final DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
    private UsersDAO usersDAO;
    private WorkersDAO workersDAO;

    @Override
    public void init(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
        super.init(context, request, response);
     /*   usersDAO = factory.getUserDAO();
        workersDAO = factory.getWorkersDAO();*/
        workersDAO = (WorkersDAO) request.getServletContext().getAttribute("workersDAO");
        usersDAO = (UsersDAO) request.getServletContext().getAttribute("userDAO");

    }

    @Override
    public void send() throws IOException {
        List<User> usersList = usersDAO.getRequest();
        String login = request.getParameter("userLogin");
        String password = request.getParameter("userPassword");//fix pass chek
        System.out.println("Ligin = " + login + "Password = " + password);

        User user = usersDAO.getUserByLogin(login);
        if (user == null) {
            try {
                forward("/User-not-found");
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }

        int idUser = 0;
        idUser = user.getIdUser();

/*        if (!password.equals(user.getPassword())) {
            try {
                forward("/wrong-password.jsp");
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }*/

        int idUserType = user.getIdUserType();
        request.getSession().setAttribute("idUser", idUser);
        if (user.isBlocked() == 1){
            try {
                forward("/banned.jsp");
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }
        try {

            request.setAttribute("loginProcess", true);


            if (idUserType == 1) {
                setOnlineStatus(user, request);
                forward("/admin-page.jsp");

            } else if (idUserType == 2) {
                forward("/moder-page.jsp");

            } else if (idUserType == 3) {
                Worker worker = workersDAO.getWorkerById(idUser);
                if (worker.getPost().equals(Post.CAPTAIN)) {
                    forward("/captain-page.jsp");

                } else if (worker.getPost().equals(Post.PILOT)) {
                    forward("/pilot-page.jsp");

                } else if (worker.getPost().equals(Post.DISPATCHER)) {
                    forward("/dispatcher-page.jsp");

                }
            }
        } catch (ServletException exception) {
            exception.printStackTrace();
        }

    }
    private void setOnlineStatus(User user, HttpServletRequest event) {
        try {
            System.out.println("In set online method(login)");
            UsersDAO usersDAO = (UsersDAO) event.getSession().getServletContext().getAttribute("userDAO");
            User updateUser = new User(user.getIdUser(), user.getIdUserType(), user.getLogin(),
                    user.getPassword(), 1, user.isBlocked());
            usersDAO.updateUser(updateUser);
            System.out.println("Update online status in login = " + 1);
        } catch (NullPointerException e) {
            System.out.println("Null pointer in login");
            return;
        }

    }

}