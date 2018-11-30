package ru.kpfu.itis.filter;

import ru.kpfu.itis.form.SignUpForm;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class SignUpFormSaverFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
            throws IOException, ServletException {
        if (("get".equalsIgnoreCase(((HttpServletRequest) req).getMethod()))) {
            filterChain.doFilter(req, resp);
            return;
        }
        req.setCharacterEncoding("UTF-8");
        SignUpForm form = SignUpForm.builder()
                .username(req.getParameter("username").trim())
                .email(req.getParameter("email").trim())
                .password(req.getParameter("password"))
                .build();
        System.err.println(form);
        req.setAttribute("signUpForm", form);
        filterChain.doFilter(req, resp);
    }
}
