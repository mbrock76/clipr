package com.clipr.users_coupons.service;

import com.clipr.users_coupons.repository.UsersCouponsRepo;
import com.clipr.users_coupons.model.UserCoupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

@Service
public class UsersCouponsService {

    @Autowired
    UsersCouponsRepo myUsersCouponsRepo;

    //create a new user x coupon record
    public void postUserCoupon(UserCoupon myUserCoupon){ myUsersCouponsRepo.save(myUserCoupon); }

    //get a usercoupon with a supplied user_coupon_id
    public UserCoupon getUserCouponById(Integer id){ return myUsersCouponsRepo.findById(id).orElse(new UserCoupon()); }

    //get a list of all user/coupon records
    public List<UserCoupon> getAllUsersCoupons(){ return myUsersCouponsRepo.findAll(); }

    //get a string of coupon ids matching a supplied user id
    public String getCouponsByUserId(Integer id){

        List<UserCoupon> temp = myUsersCouponsRepo.findByuserId(id);

        //concatenate coupon ids into one string
        String couponIds = "";
        for(UserCoupon each:temp){

            couponIds += each.getCouponId() + " ";
        }

        return couponIds;
    }

    //get a string of user ids matching a supplied coupon id
    public String getUsersByCouponId(Integer id){

        List<UserCoupon> temp = myUsersCouponsRepo.findBycouponId(id);

        //concatenate user ids into one string
        String userIds = "";
        for(UserCoupon each:temp){

            userIds += each.getUserId() + " ";
        }

        return userIds;
    }

    //delete a user x coupon record with a supplied id
    public void deleteUserCouponById(Integer id){ myUsersCouponsRepo.deleteById(id); }

    //delete all user x coupon records that match a supplied user id
    public void deleteAllByUserId(Integer id){ myUsersCouponsRepo.deleteAllByuserId(id); }

    //delete all user x coupon records that match a supplied coupon id
    public void deleteAllByCouponId(Integer id){ myUsersCouponsRepo.deleteAllBycouponId(id); }

}
