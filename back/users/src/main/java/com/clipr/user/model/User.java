package com.clipr.user.model;

import lombok.Data;
import javax.persistence.*;

@Entity(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;
    @Column(name = "user_type")
    private String userType;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "pass_word")
    private String passWord;
    private String email;
    private int clipped;
    private int redeemed;
    private int created;

}
