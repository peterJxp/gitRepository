package com.ssm.dao;

import com.ssm.model.Person;

import java.util.List;

public interface PersonDao {

    void addPer(Person person);//新增

    List<Person> queryAll();  //查询全部

    int delete(String id);//删除

    int update(Person person);//更新

    Person onePer(String id);//单个查询

    int getTotal();//总记录数
}
