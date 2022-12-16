package com.joy.otproject.repository;

import com.joy.otproject.entity.Room;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

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

    public List<Integer> findAllByString(String userId, String type) {
        return em.createQuery("select distinct r.floor from ot_room r join r.user u where r.roomType = :type and u.userId= :userId order by r.floor", Integer.class)
                .setParameter("type", type)
                .setParameter("userId", userId)
                .getResultList();
    }

    public List<Room> findAllByString2(String userId, String type, Integer floor) {
        return em.createQuery("select r from ot_room r join r.user u where r.roomType = :type and u.userId= :userId and r.floor= :floor order by r.roomNumber", Room.class)
                .setParameter("type", type)
                .setParameter("userId", userId)
                .setParameter("floor", floor)
                .getResultList();
    }
}
