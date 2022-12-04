package ru.rsreu.control.commands;

import ru.rsreu.datalayer.DAO.DAOFactory;
import ru.rsreu.datalayer.DAO.DBType;
import ru.rsreu.datalayer.DAO.UsersDAO;
import ru.rsreu.datalayer.data.User;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteUserCommand extends Command {
    private static final DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
    private UsersDAO usersDAO;

    @Override
    public void init(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
        super.init(context, request, response);
        usersDAO = factory.getUserDAO();
    }

    @Override
    public void send() {
        String id = request.getParameter("id");
        User user = usersDAO.getUserById(id);
        if (user == null) {
            return;
        }
        usersDAO.deleteUser(user);
    }
}
