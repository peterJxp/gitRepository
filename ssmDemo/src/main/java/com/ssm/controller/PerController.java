package com.ssm.controller;/*
  Created by IntelliJ IDEA.
  User: jxp
  Date: 2018/5/3/003
  Time:11:22
  To change this template use File | Settings | File Templates.
*/

import com.ssm.model.Person;
import com.ssm.service.PersonIDao;
import com.ssm.util.Paging;
import com.ssm.util.ReponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/perTest")
public class PerController {

    @Autowired
    private PersonIDao personIDao;

    /**
     * 用户分页查询
     *
     * @param page
     * @param rows
     * @param person
     * @param res
     * @return
     * @throws Exception
     */
    @RequestMapping("/list")
    public String list(@RequestParam(value = "page", required = false) String page, @RequestParam(value = "rows", required = false) String rows, Person person, HttpServletResponse res) throws Exception {
        Paging pageBean = new Paging(Integer.parseInt(page), Integer.parseInt(rows));
        List<Person> personList=personIDao.queryAll();
        int total=personIDao.getTotal();
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(personList);
        result.put("rows", jsonArray);
        result.put("total", total);
        ReponseUtil.out(res, result);
        return null;
    }

    @RequestMapping("/add")
    public ModelAndView add(Person person,HttpServletResponse response) {
        if (person.getId()!=null){
            personIDao.update(person);
        }else {
            person.setId(UUID.randomUUID().toString().replace("-",""));
            personIDao.addPer(person);
        }
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("success",true);
        try {
            ReponseUtil.out(response,jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/deletePer")
    public ModelAndView delete(String ids,HttpServletResponse httpServletResponse) {
        int  a=0;
       String[] idArray= ids.split(",");
       for(String id:idArray){
            a = personIDao.delete(id);
       }
      if (a==1){
          JSONObject jsonObject=new JSONObject();
          jsonObject.put("success",true);
          try {
              ReponseUtil.out(httpServletResponse,jsonObject);
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
        return null;
    }


}
