package com.joy.hpptproject.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "hppt_user")
@Getter @Setter
public class User {
    @Id
    String userId;
    String userPw;
    String userName;
    String address;
    @CreatedDate
    LocalDateTime createdDate;
}
