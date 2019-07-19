package com.servlet;

import com.dao.CountsDao;
import com.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class VerificationCountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        CountsDao cd = new CountsDao();
        int result = cd.check(username,password);
        PrintWriter out = resp.getWriter();
        if(result==1){
            HttpSession hs = req.getSession();
            User user = new User(username,password);
            hs.setAttribute("user",user);

            out.println("<script type='text/javascript'>alert('登陆成功！');location.href='showallgoods';</script>");
//            req.getRequestDispatcher("showallgoods").forward(req,resp);
        }else if(result==2){
            out.println("<script type='text/javascript'>alert('密码错误！');location.href='index.jsp';</script>");
//            resp.sendRedirect("index.jsp");
        }
        else if(result==3){
            out.println("<script type='text/javascript'>alert('用户不存在！');location.href='index.jsp';</script>");

        }
    }
}
