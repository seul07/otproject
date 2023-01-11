package com.joy.hpptproject.service;

import com.joy.hpptproject.entity.Room;
import com.joy.hpptproject.entity.User;
import com.joy.hpptproject.repository.RoomRepository;
import com.joy.hpptproject.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HpptProjectService {

    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    public HpptProjectService(
            RoomRepository roomRepository,
            UserRepository userRepository
    ) {
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
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

    public User findUser(String userId) {
        return userRepository.find(userId);
    }
}
