package com.dao;

import com.entity.Goods;
import com.entity.User;

import java.sql.*;

public class CountsDao {
    Dao dao = new Dao();
    Connection con =null;
    PreparedStatement pra = null;
    ResultSet rs = null;

    //如果登陆成功返回1；密码错误返回2；用户不存在返回3；
    public int check(String user,String pasd){
        int i =0;
        try {
            String username = user;
            con = dao.getConnection();
            StringBuffer sf = new StringBuffer();
            sf.append("select * from userinfo where username = ? ");
            pra = con.prepareStatement(sf.toString());
            pra.setObject(1,user);
            ResultSet set = pra.executeQuery();
            if(set.next()){
                if(pasd.equals(set.getString("password"))){
                    i= 1;
                }
                else {
                    i= 2;
                }
            }else{
                i= 3;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dao.closeAll(con,pra,rs);
        }
        return i;
    }


    public void uploadCount(User user){
        try {

            Connection con = null;
            PreparedStatement pra = null;
            ResultSet rs = null;
            con = new Dao().getConnection();
            StringBuffer sf = new StringBuffer();
            sf.append("insert into userinfo (username,password,sex,hobbys,phone,email,addrs) values (  ? , ? , ? , ? , ? , ? ,?)");
            pra = con.prepareStatement(sf.toString());
            pra.setObject(1,user.getUsername());
            pra.setObject(2,user.getPassword());
            pra.setObject(3,user.getSex());
            pra.setObject(4,user.getXingqu());
            pra.setObject(5,user.getPhone());
            pra.setObject(6,user.getEmail());
            pra.setObject(7,user.getAddrs());
            System.out.println("注册成功");
            System.out.println(sf.toString());
            pra.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.closeAll(con,pra,rs);
        }

    }
}
