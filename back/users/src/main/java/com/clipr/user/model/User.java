package com.clipr.user.model;

import lombok.Data;
import javax.persistence.*;

@Entity(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;
    private String user_type;
    private String user_name;
    private String pass_word;
    private String email;
    private int clipped;
    private int redeemed;
    private int created;

}
