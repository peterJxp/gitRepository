package com.ssm.service;

import com.ssm.dao.PersonDao;
import com.ssm.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("all")
@Service
public class PerosnIDaoImp implements PersonIDao {

    @Autowired
    private PersonDao personDao;

    public void addPer(Person person) {
        personDao.addPer(person);
    }

    public List<Person> queryAll() {
        return personDao.queryAll();
    }

    public int delete(String id) {
        return personDao.delete(id);
    }

    public int update(Person person) {
        return personDao.update(person);
    }

    public Person selectOne(String id) {
        return personDao.onePer(id);
    }

    public int getTotal() {
        return personDao.getTotal();
    }
}
