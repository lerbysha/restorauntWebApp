package ru.kpfu.itis.servlet;



import ru.kpfu.itis.form.ProfileUpdateForm;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.service.UserService;
import javax.servlet.ServletConfig;
        import javax.servlet.ServletContext;
        import javax.servlet.ServletException;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.util.Optional;

public class ProfileServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        userService = (UserService) context.getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<User> userCandidate = userService.identifyUserByToken(req.getRequestedSessionId());
        if (userCandidate.isPresent()) {
            User user = userCandidate.get();
            req.getSession().setAttribute("user", user);
            req.getRequestDispatcher("/WEB-INF/views/profileView.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProfileUpdateForm form = (ProfileUpdateForm) req.getAttribute("profileUpdateForm");
        User signedUser = (User) req.getSession().getAttribute("user");
        req.getRequestDispatcher("/WEB-INF/views/profileView.jsp").forward(req, resp);
    }
}