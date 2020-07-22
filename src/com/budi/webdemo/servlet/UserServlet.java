package com.budi.webdemo.servlet;

import com.budi.webdemo.domain.User;
import com.budi.webdemo.service.impl.UserSeiveImpl;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserSeiveImpl seive = new UserSeiveImpl();
        List<User> userList = seive.selectAllUser();
        req.setAttribute("userList",userList.toArray());
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
