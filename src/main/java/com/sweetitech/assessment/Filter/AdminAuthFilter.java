package com.sweetitech.assessment.Filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.sweetitech.assessment.Utils.AuthUtils.isLoggedIn;
import static com.sweetitech.assessment.Utils.AuthUtils.isLoginURL;


@WebFilter("/*")
public class AdminAuthFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(AdminAuthFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        request.getRequestURL();

        log.info("IP: " + request.getRemoteAddr() + " Servlet Path: " + request.getServletPath());

        if (isLoginURL(request) || isLoggedIn(request) || request.getServletPath().equals("/about")) {
            chain.doFilter(req, res);
        } else {
            response.sendRedirect("/login");
        }
    }

    @Override
    public void destroy() {

    }

}
