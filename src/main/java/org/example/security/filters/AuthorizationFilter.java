package org.example.security.filters;

import org.example.security.UserService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AuthorizationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Authorization filter");
        String user = ((HttpServletRequest) servletRequest).getHeader("user");
        List<String> permittedUrls = UserService.permissions.get(user);
        String requestURI = ((HttpServletRequest) servletRequest).getRequestURI();
        if (!permittedUrls.contains(requestURI)) {
            ((HttpServletResponse) servletResponse).setStatus(403);
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
