package com.clipr.users_coupons.repository;

import com.clipr.users_coupons.model.UserCoupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersCouponsRepo extends JpaRepository<UserCoupon, Integer> {

    List<UserCoupon> findByuserId(int user_id);

    List<UserCoupon> findBycouponId(int coupon_id);

    void deleteAllByuserId(int user_id);

    void deleteAllBycouponId(int coupon_id);
}
