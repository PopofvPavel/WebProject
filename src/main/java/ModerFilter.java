import ru.rsreu.datalayer.DAO.UsersDAO;
import ru.rsreu.datalayer.data.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ModerFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("In moder filter");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        Integer idUser = (Integer) httpRequest.getSession().getAttribute("idUser");
        User user = ((UsersDAO)request.getServletContext().getAttribute("userDAO")).getUserById(idUser);
        if (user.getIdUserType() == 2) {
            System.out.println("User is moder");
            chain.doFilter(request, response);
        } else {
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            System.out.println("User is not moder");
        }
    }
}
