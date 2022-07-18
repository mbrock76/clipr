package com.clipr.coupon.model;

import lombok.Data;
import javax.persistence.*;

@Entity(name = "coupons")
@Data
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "coupon_id")
    private int coupon_id;
    private int created_by;
    private int store_id;
    private String product_id;
    private String product_name;
    private double discount;
    private String discount_type;
    private int qty_redeemed;
    private int created;
    private int expires;

}
