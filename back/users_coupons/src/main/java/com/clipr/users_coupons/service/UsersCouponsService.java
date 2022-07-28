package com.clipr.users_coupons.service;

import com.clipr.users_coupons.repository.UsersCouponsRepo;
import com.clipr.users_coupons.model.UserCoupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsersCouponsService {

    @Autowired
    UsersCouponsRepo myUsersCouponsRepo;

    //get a usercoupon with a supplied user_coupon_id
    public UserCoupon getUserCouponById(Integer id){ return myUsersCouponsRepo.findById(id).orElse(new UserCoupon()); }

    //get a list of all user/coupon records
    public List<UserCoupon> getAllUsersCoupons(){ return myUsersCouponsRepo.findAll(); }

    //get a list of coupons matching a supplied user id
    public List<UserCoupon> getCouponsByUserId(Integer id){ return myUsersCouponsRepo.findByuserId(id); }

    //get a list of users matching a supplied coupon id
    public List<UserCoupon> getUsersByCouponId(Integer id){ return myUsersCouponsRepo.findBycouponId(id); }
}
