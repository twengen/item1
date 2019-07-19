package com.dao;

import java.sql.*;

public class Dao {
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false&serverTimezone=CST";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(DRIVER_CLASS);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//            System.out.println(con);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public void closeAll(Connection conn, PreparedStatement sta, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (sta != null) sta.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
