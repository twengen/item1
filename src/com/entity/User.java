package com.entity;

public class User {
    private String username;
    private String password;
    private String sex;
    private String xingqu;
    private String phone;
    private String email;
    private String addrs;

    public User(String username, String password, String sex, String xingqu, String phone, String email, String addrs) {
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.xingqu = xingqu;
        this.phone = phone;
        this.email = email;
        this.addrs = addrs;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getXingqu() {
        return xingqu;
    }

    public void setXingqu(String xingqu) {
        this.xingqu = xingqu;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddrs() {
        return addrs;
    }

    public void setAddrs(String addrs) {
        this.addrs = addrs;
    }

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
