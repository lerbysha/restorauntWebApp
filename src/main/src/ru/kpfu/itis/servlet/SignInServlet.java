package ru.kpfu.itis.servlet;
import ru.kpfu.itis.form.SignInForm;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.service.UserService;
import ru.kpfu.itis.service.WrongEmailOrPasswordException;
import ru.kpfu.itis.util.RequestUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Optional;

public class SignInServlet extends HttpServlet {
    private static final String SESSION_COOKIE_NAME = "SESSION_TOKEN";
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        userService = (UserService) context.getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/WEB-INF/views/sign_inView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SignInForm form = (SignInForm) req.getAttribute("signInForm");
        try {
            User authorizedUser = userService.signIn(form);
            HttpSession session = req.getSession();
            authorizedUser.setToken(session.getId());
            userService.update(authorizedUser);
            Optional<Cookie> sessionCookieCandidate = RequestUtil.getAuthCookie(req);
            System.err.println(authorizedUser);
            Cookie sessionCookie = sessionCookieCandidate.orElseGet(
                    () -> new Cookie(SESSION_COOKIE_NAME, session.getId()));
            sessionCookie.setMaxAge(100000000);
            resp.addCookie(sessionCookie);

            session.setAttribute("user", authorizedUser);
            resp.sendRedirect("/profile");
        } catch (WrongEmailOrPasswordException e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/views/sign_inView.jsp").forward(req, resp);
        }
    }

    @Override
    public void destroy() {
        userService = null;
    }
}