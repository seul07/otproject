package com.joy.otproject.service;

import com.joy.otproject.entity.Room;
import com.joy.otproject.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OtService {

    private final RoomRepository roomRepository;

    public OtService(
            @Qualifier("roomRepository") RoomRepository roomRepository
    ) {
        this.roomRepository = roomRepository;
    }

    public List<Integer> findFloor(String userId, String type) {
        return roomRepository.findAllByString(userId,type);
    }

    public List<Room> findRooms(String userId, String type, String floor) {
        return roomRepository.findAllByString2(userId,type,Integer.parseInt(floor));
    }

    @Transactional
    public void updateRoom(String userId, String id, String newOccupy){
        Room room = roomRepository.find(Long.parseLong(id));
        room.setId(Long.parseLong(id));
        room.setOccupy(newOccupy);
        roomRepository.save(room);
    }
}
