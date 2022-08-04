package com.clipr.coupon.model;

import lombok.Data;
import javax.persistence.*;

@Entity(name = "coupons")
@Data
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int coupon_id;
    @Column(name = "created_by")
    private int createdBy;
    @Column(name = "store_id")
    private int storeId;
    @Column(name = "product_id")
    private String productId;
    @Column(name = "product_name")
    private String productName;
    private double discount;
    @Column(name = "discount_type")
    private String discountType;
    @Column(name = "qty_redeemed")
    private int qtyRedeemed;
    private int created;
    private int expires;

}
