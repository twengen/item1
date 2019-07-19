package com.servlet;

import com.dao.GoodsDao;
import com.entity.Goods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GoodsLoadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);

        req.setCharacterEncoding("utf-8");
        int goodsid = Integer.valueOf(req.getParameter("goodsId"));
        Goods goods =new Goods(goodsid);
        GoodsDao gd = new GoodsDao();
        List<Goods> list=gd.findByGoods(goods);
        req.setAttribute("goods",list.get(0));
        req.getRequestDispatcher("goods_update.jsp").forward(req,resp);
    }
}
