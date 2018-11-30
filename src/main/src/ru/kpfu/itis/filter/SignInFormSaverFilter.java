package ru.kpfu.itis.filter;

import ru.kpfu.itis.form.SignInForm;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class SignInFormSaverFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        if (("get".equalsIgnoreCase(((HttpServletRequest) req).getMethod()))) {
            filterChain.doFilter(req, resp);
            return;
        }
        req.setCharacterEncoding("UTF-8");
        SignInForm form = SignInForm.builder()
                .username(req.getParameter("username").trim())
                .password(req.getParameter("password"))
                .build();

        System.err.println(form);
        req.setAttribute("signInForm", form);
        filterChain.doFilter(req, resp);
    }
}
