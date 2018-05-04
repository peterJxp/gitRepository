package com.ssm.service;

import com.ssm.model.Person;

import java.util.List;

public interface PersonIDao {

    void addPer(Person person);//新增

    List<Person> queryAll();

    int delete(String id);

    int update(Person person);

    Person selectOne(String id);

    int getTotal();

}
