package com.joy.hpptproject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "hppt_room")
@Getter @Setter
public class Room {
    @Id
    @GeneratedValue
    Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
    Integer floor;
    String roomNumber;
    String roomType;
    String occupy;
    String vh;

}
