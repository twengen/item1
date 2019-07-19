package com.servlet;

import com.dao.CountsDao;
import com.entity.Goods;
import com.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        req.setCharacterEncoding("utf-8");
        String newuser = req.getParameter("username");
        String newpasd = req.getParameter("password");
        String sex = req.getParameter("sex");
        String xingqu = req.getParameter("xingqu");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String addrs = req.getParameter("addrs");

        CountsDao cd = new CountsDao();
        User user = new User(newuser,newpasd,sex,xingqu,phone,email,addrs);
        cd.uploadCount(user);
    }
}
