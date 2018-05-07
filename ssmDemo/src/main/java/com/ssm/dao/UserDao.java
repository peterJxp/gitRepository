package com.ssm.dao;/*
  Created by IntelliJ IDEA.
  User: jxp
  Date: 2018/5/4/004
  Time:15:22
  To change this template use File | Settings | File Templates.
*/

import com.ssm.model.User;

public interface UserDao {

    User userLogin(User user);//验证登陆
}
