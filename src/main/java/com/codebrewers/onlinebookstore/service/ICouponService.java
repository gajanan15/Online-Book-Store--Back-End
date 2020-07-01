package com.codebrewers.onlinebookstore.service;

import com.codebrewers.onlinebookstore.model.Coupons;

import java.util.List;

public interface ICouponService {
    List<Coupons> fetchCoupon(String token,Double totalPrice);

    Double addCoupon(String token, String coupon, Double totalPrice);
}
