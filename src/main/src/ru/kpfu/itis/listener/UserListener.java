package ru.kpfu.itis.listener;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.kpfu.itis.repos.UserRepository;
import ru.kpfu.itis.repos.UserRepositoryImpl;
import ru.kpfu.itis.service.UserService;
import ru.kpfu.itis.util.DatabaseManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import java.sql.Connection;

@WebListener
public class UserListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        Connection cn = DatabaseManager.getDataSource();

        UserRepository userRepository = new UserRepositoryImpl(cn);
        UserService userService = new UserService(userRepository);
        context.setAttribute("userRepository", userRepository);
        context.setAttribute("userService", userService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
