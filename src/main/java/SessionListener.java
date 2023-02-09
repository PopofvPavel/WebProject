import com.prutzkow.resourcer.Resourcer;
import ru.rsreu.datalayer.DAO.UsersDAO;
import ru.rsreu.datalayer.data.User;

import javax.servlet.*;
import javax.servlet.http.*;

public class SessionListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public SessionListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Listener start");
        Resourcer resourcer = ((Resourcer)(se.getSession().getServletContext().getAttribute("resourcer")));
        System.out.println(resourcer.getString("db.url"));
       // setOnlineStatus(1,se);

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Listener session destroy method");
        setOnlineStatus(0,se);


    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is added to a session. */
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is removed from a session. */
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is replaced in a session. */
    }

    private void setOnlineStatus(int onlineStatus, HttpSessionEvent event) {
        try {
            System.out.println("In set not online method");
            UsersDAO usersDAO = (UsersDAO) event.getSession().getServletContext().getAttribute("userDAO");
            String id = (String) event.getSession().getAttribute("idUser");
            User user = usersDAO.getUserById(id);
            User updateUser = new User(user.getIdUser(), user.getIdUserType(), user.getLogin(),
                    user.getPassword(), onlineStatus, user.isBlocked());
            usersDAO.updateUser(updateUser);
            System.out.println("Update online status in listener" + onlineStatus);
        } catch (NullPointerException e) {
            System.out.println("Null pointer in listener");
            return;
        }

    }
}
