package com.clipr.coupon.service;

import com.clipr.coupon.repository.CouponRepo;
import com.clipr.coupon.model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

@Service
public class CouponService {

    @Autowired
    CouponRepo myCouponRepo;

    //get a list of all coupons
    public List<Coupon> getAllCoupons() { return myCouponRepo.findAll(); }

    //get one coupon with supplied id
    public Coupon getCouponById(Integer id){ return myCouponRepo.findById(id).orElse(new Coupon()); }

    //get a list of coupons associated with a supplied user id
    public String getCouponsByUserId(Integer id){

        WebClient myWebClient = WebClient.create();

        WebClient.ResponseSpec myReSpec = myWebClient.get()
                .uri("http://localhost:8084/users_coupons/" + id)
                .retrieve();


        return myReSpec.bodyToMono(String.class).block();
    }

    //create a new coupon record
    public void createNewCoupon(Coupon myCoupon){ myCouponRepo.save(myCoupon); }

    //delete a coupon record
    public void deleteCouponById(Integer id){ myCouponRepo.deleteById(id); }

}
