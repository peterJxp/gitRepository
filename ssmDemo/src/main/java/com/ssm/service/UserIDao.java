package com.ssm.service;/*
  Created by IntelliJ IDEA.
  User: jxp
  Date: 2018/5/4/004
  Time:15:27
  To change this template use File | Settings | File Templates.
*/

import com.ssm.model.User;

public interface UserIDao {

    User userLogin(User user)throws Exception;

}
