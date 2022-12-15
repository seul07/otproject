package com.joy.otproject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "ot_room")
@Getter @Setter
public class Room {
    @Id @GeneratedValue
    Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
    Integer floor;
    String room_number;
    String room_type;
    String occupy;
    String vh;
}
