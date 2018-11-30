package ru.kpfu.itis.filter;


import ru.kpfu.itis.model.User;
import ru.kpfu.itis.service.UserService;
import ru.kpfu.itis.util.RequestUtil;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;


public class IdentificationFilter implements Filter {
    private UserService userService;

    @Override
    public void init(FilterConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        userService = (UserService) context.getAttribute("userService");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        Optional<Cookie> sessionCookieCandidate = RequestUtil.getAuthCookie(req);

        if (req.getSession(false) == null && sessionCookieCandidate.isPresent()){
            Cookie sessionCookie = sessionCookieCandidate.get();
            Optional<User> userCandidate = userService.identifyUserByToken(sessionCookie.getValue());

            if (userCandidate.isPresent()) {
                HttpSession newSession = req.getSession();
                User identifiedUser = userCandidate.get();
                identifiedUser.setToken(newSession.getId());
                newSession.setAttribute("user", identifiedUser);

                userService.update(identifiedUser);
                sessionCookie.setValue(newSession.getId());
                sessionCookie.setMaxAge(UserService.REMEMBER_ME_COOKIE_EXPIRY);
                resp.addCookie(sessionCookie);

            }
        }
        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
        userService = null;
    }
}
