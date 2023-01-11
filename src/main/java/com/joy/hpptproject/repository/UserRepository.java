package com.joy.hpptproject.repository;

import com.joy.hpptproject.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    public String save(User user){
        em.persist(user);
        return user.getUserId();
    }

    public User find(String userId){
        return em.find(User.class,userId);
    }
}
