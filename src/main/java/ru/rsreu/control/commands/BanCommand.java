package ru.rsreu.control.commands;

import ru.rsreu.datalayer.DAO.DAOFactory;
import ru.rsreu.datalayer.DAO.DBType;
import ru.rsreu.datalayer.DAO.UsersDAO;
import ru.rsreu.datalayer.data.User;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BanCommand extends Command {
    private static final DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
    private UsersDAO usersDAO;

    @Override
    public void init(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
        super.init(context, request, response);
        usersDAO = factory.getUserDAO();
    }

    @Override
    public void send() {
        String id = request.getParameter("idUserLine");
        User user = usersDAO.getUserById(id);
/*        if(user.getIdUser() == (int)request.getSession().getAttribute("idUser")){
            return;
        }*/
        System.out.println("User found:" + user.toString());
        User updateUser = new User(user.getIdUser(), user.getIdUserType(), user.getLogin(),
                user.getPassword(), user.isAuthorized(), 1);
        usersDAO.updateUser(updateUser);
        System.out.println("Banned user(command)");
    }
}
