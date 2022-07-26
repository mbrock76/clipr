package com.clipr.users_coupons.controller;

import com.clipr.users_coupons.model.UserCoupon;
import com.clipr.users_coupons.service.UsersCouponsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users_coupons")
public class UsersCouponsController {

    @Autowired
    UsersCouponsService myUsersCouponsService;

    @GetMapping
    public List<UserCoupon> getAllUsersCoupons(){ return myUsersCouponsService.getAllUsersCoupons(); }

    @GetMapping("/{id}")
    public UserCoupon getUserCouponById(Integer id){
        return  myUsersCouponsService.getUserCouponById(id);
    }

    @GetMapping("/user_id/{id}")
    public List<UserCoupon> getCouponsByUserId(Integer id){
        System.out.println(id);
        return myUsersCouponsService.getCouponsByUserId(id); }

    @GetMapping("/coupon_id/{id}")
    public List<UserCoupon> getUsersByCouponId(Integer id){ return myUsersCouponsService.getCouponsByUserId(id); }


}
