package com.joy.otproject.repository;

import com.joy.otproject.entity.Member;
import com.joy.otproject.entity.Room;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.UUID;

@Repository
public class RoomRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Room room){
        em.persist(room);
        return room.getId();
    }

    public Room find(Long id){
        return em.find(Room.class,id);
    }
}
