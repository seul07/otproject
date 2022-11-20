package com.joy.otproject.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

@Entity(name = "ot_room")
@Getter @Setter
public class Room {
    @Id @GeneratedValue
    Long id;
    @ManyToOne
    @JoinColumn(name = "ot_mem_id")
    Member mem_id;
    Integer floor;
    String room_number;
    String room_type;
    String occupy;
    String vh;
}
