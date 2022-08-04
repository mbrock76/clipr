package com.clipr.users_stores.model;

import lombok.Data;
import javax.persistence.*;

@Entity(name = "users_stores")
@Data
public class UserStore {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_store_id;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "store_id")
    private int storeId;
}
