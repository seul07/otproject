package com.joy.otproject.repository;

import com.joy.otproject.entity.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.UUID;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public UUID save(Member user){
        em.persist(user);
        return user.getId();
    }

    public Member find(UUID id){
        return em.find(Member.class,id);
    }
}
