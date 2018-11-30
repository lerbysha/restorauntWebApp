package ru.kpfu.itis.servlet;

import ru.kpfu.itis.service.MenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class MenuServlet extends HttpServlet {
    private MenuService ms = new MenuService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("menu", ms.getMenu());
        ms.getMenu().forEach(System.out::println);
        request.getRequestDispatcher("/WEB-INF/views/menuView.jsp").forward(request, response);
    }
}
