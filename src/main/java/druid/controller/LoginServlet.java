package druid.controller;


import druid.service.UserService;
import druid.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        int i = userService.selectTrue(username, password);

        if (i == 1){
            req.getRequestDispatcher("/pages/success.html").forward(req,resp);
            return;
        }else {
            req.getRequestDispatcher("/pages/login.html").forward(req,resp);
        }
    }
}
