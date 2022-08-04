package com.clipr.stores.model;

import lombok.Data;
import javax.persistence.*;

@Entity(name = "stores")
@Data
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int store_id;
    @Column(name = "store_name")
    private String storeName;
    private String address;
    private String company;
    private String email;

}
