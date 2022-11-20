package com.joy.otproject.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "ot_member")
@Getter @Setter
public class Member {
//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
//    @Column(columnDefinition = "BINARY(16)")
    @Type(type="org.hibernate.type.UUIDCharType")
    UUID id;
    String ot_mem_id;
    String ot_mem_pw;
    String address;
    String mobile;
    @CreatedDate
    LocalDateTime created_date;

}
