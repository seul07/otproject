package com.joy.otproject.service;

import com.joy.otproject.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
}
