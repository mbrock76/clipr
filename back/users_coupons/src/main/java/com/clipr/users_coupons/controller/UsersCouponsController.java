package com.clipr.users_coupons.controller;

import com.clipr.users_coupons.model.UserCoupon;
import com.clipr.users_coupons.service.UsersCouponsService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users_coupons")
public class UsersCouponsController {

    @Autowired
    UsersCouponsService myUsersCouponsService;

    @PostMapping
    public void postUserCoupon(@RequestBody UserCoupon myUserCoupon){ myUsersCouponsService.postUserCoupon(myUserCoupon); }

    @GetMapping
    public List<UserCoupon> getAllUsersCoupons(){ return myUsersCouponsService.getAllUsersCoupons(); }

    @GetMapping("/{id}")
    public UserCoupon getUserCouponById(@PathVariable Integer id){ return  myUsersCouponsService.getUserCouponById(id); }

    @GetMapping("/user_id/{id}")
    public String getCouponsByUserId(@PathVariable Integer id){ return myUsersCouponsService.getCouponsByUserId(id); }

    @GetMapping("/coupon_id/{id}")
    public String getUsersByCouponId(@PathVariable Integer id){ return myUsersCouponsService.getUsersByCouponId(id); }

    //there is no updating a user x coupon record, dont use this
    @PutMapping
    public void putUserCoupon(@RequestBody UserCoupon myUserCoupon){ myUsersCouponsService.postUserCoupon(myUserCoupon); }

    @DeleteMapping("/{id}")
    public void deleteUserCouponById(@PathVariable Integer id){ myUsersCouponsService.deleteUserCouponById(id); }

    @DeleteMapping("/user_id/{id}")
    public void deleteAllByUserId(@PathVariable Integer id){ myUsersCouponsService.deleteAllByUserId(id); }

    @DeleteMapping("/coupon_id/{id}")
    public void deleteAllByCouponId(@PathVariable Integer id){ myUsersCouponsService.deleteAllByCouponId(id); }

}
