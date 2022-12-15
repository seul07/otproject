package com.joy.otproject.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "ot_user")
@Getter @Setter
public class User {
    @Id
    String userId;
    String userPw;
    String userName;
    String address;
    @CreatedDate
    LocalDateTime createdDate;
    String otUsercol;
}
