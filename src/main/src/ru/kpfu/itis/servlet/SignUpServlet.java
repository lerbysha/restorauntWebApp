package ru.kpfu.itis.servlet;

import ru.kpfu.itis.form.SignInForm;
import ru.kpfu.itis.form.SignUpForm;
import ru.kpfu.itis.service.UserAlreadyExistsException;
import ru.kpfu.itis.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {


    private UserService userService;


    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        userService = (UserService) context.getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/WEB-INF/views/sign_upView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SignUpForm form = (SignUpForm) req.getAttribute("signUpForm");
        try {
            userService.signUp(form);
            resp.sendRedirect("/index.html");
        } catch (UserAlreadyExistsException e) {
            req.setAttribute("signUpAlert", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/views/sign_upView.jsp").forward(req, resp);
        }
    }
}

