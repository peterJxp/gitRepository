package com.ssm.model;/*
  Created by IntelliJ IDEA.
  User: jxp
  Date: 2018/5/4/004
  Time:15:19
  To change this template use File | Settings | File Templates.
*/

public class User {

    private  int id;
    private String uname;
    private  String password;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
