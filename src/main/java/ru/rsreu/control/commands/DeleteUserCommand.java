package ru.rsreu.control.commands;

import ru.rsreu.datalayer.DAO.UsersDAO;
import ru.rsreu.datalayer.data.User;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteUserCommand extends Command {
    //private static final DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
    private UsersDAO usersDAO;

    @Override
    public void init(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
        super.init(context, request, response);
        usersDAO = (UsersDAO)(request.getServletContext().getAttribute("userDAO"));
    }

    @Override
    public void send() {
        String id = request.getParameter("id");
        User user = usersDAO.getUserById(id);
        if(user.getIdUser() == (int)request.getSession().getAttribute("idUser")){
            return;
        }
        System.out.println("User found:" + user.toString());
        if (user == null ) {
            return;
        }
        usersDAO.deleteUser(user);
        System.out.println("Deleted user(command)");
    }
}
