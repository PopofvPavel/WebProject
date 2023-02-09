import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        Integer idUser = (Integer) httpRequest.getSession().getAttribute("idUser");
        boolean isLoginProcess = request.getParameter("loginProcess") == null;
        System.out.println("Is login = " + isLoginProcess);

        if ((!isLoginProcess) && (idUser == null)) {
            System.out.println("idUserIsNull");
            //httpServletResponse.sendRedirect("D:\\AARadik\\A_Java\\AAProekt\\demo\\demo\\src\\main\\webapp\\login.jsp");
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        } else {

            System.out.println("Not in id user");
            chain.doFilter(request, response);
        }

       /* System.out.println("in filter");
        chain.doFilter(request, response);*/
    }
}
