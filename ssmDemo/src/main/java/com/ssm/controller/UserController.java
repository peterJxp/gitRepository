package com.ssm.controller;/*
  Created by IntelliJ IDEA.
  User: jxp
  Date: 2018/5/4/004
  Time:15:29
  To change this template use File | Settings | File Templates.
*/

import com.ssm.model.User;
import com.ssm.service.UserIDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Us")
public class UserController {

    @Autowired
    UserIDao userIDao;

    @RequestMapping("/login")
    public ModelAndView Login(User user){

        ModelAndView modelAndView=null;
        try {
            User userLogin=userIDao.userLogin(user);
            if (userLogin!=null){
                 modelAndView=new ModelAndView("perInfoTest");
                 return  modelAndView;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  new ModelAndView("page/login");
    }
}
