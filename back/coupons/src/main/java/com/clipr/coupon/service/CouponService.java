package com.clipr.coupon.service;

import com.clipr.coupon.repository.CouponRepo;
import com.clipr.coupon.model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CouponService {

    @Autowired
    CouponRepo myCouponRepo;

    //get a list of all coupons
    public List<Coupon> getAllCoupons() { return myCouponRepo.findAll(); }

    //get one coupon with supplied id
    public Coupon getCouponById(Integer id){ return myCouponRepo.findById(id).orElse(new Coupon()); }

    //create a new coupon record
    public void createNewCoupon(Coupon myCoupon){ myCouponRepo.save(myCoupon); }

}
