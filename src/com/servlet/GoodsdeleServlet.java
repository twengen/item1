package com.servlet;

import com.dao.GoodsDao;
import com.entity.Goods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GoodsdeleServlet extends HttpServlet {
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
        PrintWriter out = resp.getWriter();
        GoodsDao gd = new GoodsDao();
        Goods goods = new Goods(Integer.valueOf(req.getParameter("goodsId")));
        gd.deleGoods(goods);
        out.println("<script type='text/javascript'>alert('删除成功！');location.href='showallgoods';</script>");
//        resp.sendRedirect("showallgoods");
    }
}
