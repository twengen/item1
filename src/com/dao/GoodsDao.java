package com.dao;

import com.entity.Goods;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoodsDao {

    public List<Goods> findByGoods(Goods goods) {
        Dao dao = new Dao();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pra = null;
        List<Goods> goodlist = new ArrayList<>();
        conn = dao.getConnection();
        StringBuffer sf = new StringBuffer();
        List<Object> paramList = new ArrayList<>();
        sf.append("select * from goodsinfo where 1=1 ");

        try {
            if (goods != null) {
                if (goods.getId() > 0) {
                    sf.append(" and id = ? ");
                    paramList.add(goods.getId());
                    System.out.println(paramList.get(0));
                }
            }

            pra = conn.prepareStatement(sf.toString());
            for (int i = 0; i < paramList.size(); i++) {
                pra.setObject(i + 1, paramList.get(i));
            }
            System.out.println("sql:" + sf.toString());
            rs = pra.executeQuery();
            while (rs.next()) {
                Goods entity = new Goods();
                entity.setId(rs.getInt("id"));
                entity.setName(rs.getString("goodsInfo_name"));
                entity.setPic(rs.getString("goodsInfo_pic"));
                entity.setPrice(rs.getFloat("goodsInfo_price"));
                entity.setDescription(rs.getString("goodsInfo_description"));
                entity.setStock(rs.getInt("goods_stock"));
                goodlist.add(entity);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.closeAll(conn, pra, rs);
        }
        return goodlist;
    }

    public void updateGoods(Goods goods) {
        Dao dao = new Dao();
        Connection con = null;
        PreparedStatement pra = null;
        ResultSet rs = null;
        try {
            con = dao.getConnection();
            StringBuffer sf = new StringBuffer();
            sf.append("update goodsinfo set goodsInfo_name= ? ,goodsInfo_pic= ? ,goodsInfo_price= ? ,goodsInfo_description= ? ," +
                    "goods_stock = ? where id = ?");

            pra = con.prepareStatement(sf.toString());
            pra.setObject(1, goods.getName());
            pra.setObject(2, goods.getPic());
            pra.setObject(3, goods.getPrice());
            pra.setObject(4, goods.getDescription());
            pra.setObject(5, goods.getStock());
            pra.setObject(6, goods.getId());

            System.out.println(pra.toString());

            pra.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.closeAll(con, pra, rs);
        }

    }

    public void addGoods(Goods goods) {
        Dao dao = new Dao();
        Connection con = null;
        PreparedStatement pra = null;
        ResultSet rs = null;

        try {
            con = dao.getConnection();
            StringBuffer sf = new StringBuffer();
            sf.append("insert into goodsinfo (goodsInfo_name,goodsInfo_pic,goodsInfo_price,goodsInfo_description,goods_stock)" +
                    " values(?,?,?,?,?)");
            con = dao.getConnection();
            pra = con.prepareStatement(sf.toString());
            List<Object> paramList = new ArrayList<>();
            paramList.add(goods.getName());
            paramList.add(goods.getPic());
            paramList.add(goods.getPrice());
            paramList.add(goods.getDescription());
            paramList.add(goods.getStock());
            for (int i = 0; i < paramList.size(); i++) {
                pra.setObject(i+1,paramList.get(i));
            }
            pra.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.closeAll(con,pra,rs);
        }


    }

    public void deleGoods(Goods goods){
        Dao dao = new Dao();
        Connection con = null;
        PreparedStatement pra = null;
        ResultSet rs = null;

        try {
            con = dao.getConnection();
            StringBuffer sf = new StringBuffer();
            sf.append("delete from goodsinfo where id = ?");
            System.out.println(goods.getId());
            pra = con.prepareStatement(sf.toString());
            pra.setObject(1,goods.getId());
            pra.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.closeAll(con,pra,rs);
        }
    }
}
