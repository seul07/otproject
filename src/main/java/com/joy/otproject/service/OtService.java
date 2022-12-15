package com.joy.otproject.service;

import com.joy.otproject.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OtService {

    private final RoomRepository roomRepository;

    public OtService(
            @Qualifier("roomRepository") RoomRepository roomRepository
    ) {
        this.roomRepository = roomRepository;
    }

}
