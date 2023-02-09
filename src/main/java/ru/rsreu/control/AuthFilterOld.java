package ru.rsreu.control;

import javax.servlet.*;
import java.io.IOException;

public class AuthFilterOld implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
/*
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        Integer idUser = (Integer) httpRequest.getSession().getAttribute("idUser");

        if (idUser == null) {
            System.out.println("idUserIsNull");
            httpServletResponse.sendRedirect("/login.jsp");

        } else {

            System.out.println("Not in id user");
            filterChain.doFilter(servletRequest, servletResponse);
        }*/
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
