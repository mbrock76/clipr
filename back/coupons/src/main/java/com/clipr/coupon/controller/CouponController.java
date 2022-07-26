package com.clipr.coupon.controller;

import com.clipr.coupon.model.Coupon;
import com.clipr.coupon.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/coupons")
public class CouponController {

    @Autowired
    CouponService myCouponService;

    @GetMapping
    public List<Coupon> getAllCoupons(){ return myCouponService.getAllCoupons(); }

    @GetMapping("/{id}")
    public Coupon getCouponById(@PathVariable Integer id){ return myCouponService.getCouponById(id); }

    @GetMapping("/user_id/{id}")
    public String getCouponsByUserId(@PathVariable Integer id){ return myCouponService.getCouponsByUserId(id); }

    @PostMapping
    public void createNewCoupon(@RequestBody Coupon myCoupon){ myCouponService.createNewCoupon(myCoupon); }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){ myCouponService.deleteCouponById(id); }

}
