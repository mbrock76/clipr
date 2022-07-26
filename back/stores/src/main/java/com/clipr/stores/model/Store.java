package com.clipr.stores.model;

import lombok.Data;
import javax.persistence.*;

@Entity(name = "stores")
@Data
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int store_id;
    private String store_name;
    private String address;
    private String company;
    private String email;

}
