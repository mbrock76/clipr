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

    //create or update a coupon record
    public void postCoupon(Coupon myCoupon){ myCouponRepo.save(myCoupon); }

    //get a list of all coupons
    public List<Coupon> getAllCoupons(){ return myCouponRepo.findAll(); }

    //get one coupon with a matching id
    public Coupon getCouponById(Integer id){ return myCouponRepo.findById(id).orElse(new Coupon()); }

    //get a list of coupons filtered by store id
    //can be filtered client side

    //get a list of coupons filtered by user id
    public List<Coupon> getCouponsByUserId(Integer id){

        WebClient myWebClient = WebClient.create();

        //call the users x coupons microservice and get a string of coupon ids
        WebClient.ResponseSpec myReSpec = myWebClient.get()
                .uri("http://localhost:8084/users_coupons/user_id/" + id)
                .retrieve();

        //process the response into ints
        String temp = myReSpec.bodyToMono(String.class).block();
        int[] couponIds = Arrays.stream(temp.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        //get the coupon objects using the coupon ids
        List<Coupon> myCoupons = new ArrayList<Coupon>();

        for(int each:couponIds){
            myCoupons.add(myCouponRepo.findById(each).get());
        }

        return myCoupons;
    }

    //delete a coupon record
    public void deleteCouponById(Integer id){ myCouponRepo.deleteById(id); }

}
