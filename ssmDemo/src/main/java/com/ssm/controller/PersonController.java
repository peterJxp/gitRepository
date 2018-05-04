package com.ssm.controller;

import com.google.gson.Gson;
import com.ssm.model.Person;
import com.ssm.service.PersonIDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/per")
public class PersonController {

    @Autowired
    private PersonIDao personIDao;

    @RequestMapping("/add")
    public ModelAndView add(Person person) {
        person.setId(UUID.randomUUID().toString().replace("-",""));
        personIDao.addPer(person);
        ModelAndView modelAndView = new ModelAndView("perInfoTest");

        return modelAndView;
    }

    @RequestMapping("/allPer")
    public ModelAndView queryAll() {
        List<Person> personList = personIDao.queryAll();
        if (personList.size() > 0) {
            String infoToJson = new Gson().toJson(personList);
            System.out.println(infoToJson);
            ModelAndView modelAndView = new ModelAndView("page");
            modelAndView.addObject("perList", infoToJson);
            return modelAndView;
        }
        return null;
    }

    @RequestMapping("/deletePer")
    public ModelAndView delete(String id) {
        int a = personIDao.delete(id);
        ModelAndView modelAndView = new ModelAndView("success");
        modelAndView.addObject("status", "delete成功！");

        return modelAndView;
    }

    @RequestMapping("/update")
    public ModelAndView update(Person person) {
        int i = personIDao.update(person);
        ModelAndView modelAndView = null;
        if (i == 1) {
            modelAndView = new ModelAndView("success");
            modelAndView.addObject("status", "update成功！");
        }
        return modelAndView;
    }
}
