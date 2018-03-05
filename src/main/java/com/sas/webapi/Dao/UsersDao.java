package com.sas.webapi.Dao;

import com.sas.webapi.model.Users;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UsersDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Users users){
        entityManager.persist(users);
    }

    public void update(Users users){
        entityManager.merge(users);
    }
    public void delete(Users users){
        entityManager.remove(users);
    }



}
