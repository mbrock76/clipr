package com.clipr.users_coupons.model;

import lombok.Data;
import javax.persistence.*;

@Entity(name = "users_coupons")
@Data
public class UserCoupon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_coupon_id;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "coupon_id")
    private int couponId;
}
