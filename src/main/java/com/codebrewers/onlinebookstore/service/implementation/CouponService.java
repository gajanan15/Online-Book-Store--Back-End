package com.codebrewers.onlinebookstore.service.implementation;

import com.codebrewers.onlinebookstore.exception.CouponException;
import com.codebrewers.onlinebookstore.model.Coupons;
import com.codebrewers.onlinebookstore.model.CouponsDetails;
import com.codebrewers.onlinebookstore.model.UserDetails;
import com.codebrewers.onlinebookstore.repository.ICouponRepository;
import com.codebrewers.onlinebookstore.repository.IUserRepository;
import com.codebrewers.onlinebookstore.service.ICouponService;
import com.codebrewers.onlinebookstore.utils.implementation.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CouponService implements ICouponService {

    @Autowired
    ICouponRepository couponRepository;

    @Autowired
    Token jwtToken;

    @Autowired
    ICouponDetailsRepository couponDetailsRepository;

    @Autowired
    IUserRepository userRepository;


    @Override
    public List<Coupons> fetchCoupon(String token,Double totalPrice) {
        int userId = jwtToken.decodeJWT(token);
        List<Coupons> coupons = couponRepository.findAll();

        List<Coupons> couponsList=new ArrayList<>();
        for(Coupons coupons1:coupons){
            if(coupons1.minimumPrice<=totalPrice){
                couponsList.add(coupons1);
            }
        }

        List<CouponsDetails> couponsDetails = couponDetailsRepository.findByUserId(userId);

        for (CouponsDetails couponDetails1 : couponsDetails) {
            couponsList.remove(couponDetails1.coupons);
        }
        if (coupons.isEmpty() || couponsList.isEmpty())
            throw new CouponException("Coupons Not Available");

        return couponsList;
    }

    @Override
    public Double addCoupon(String token, String coupon, Double totalPrice) {
        int userId = jwtToken.decodeJWT(token);

        UserDetails user = userRepository.findById(userId).orElseThrow(() -> new CouponException("USER NOT FOUND"));
        Optional<Coupons> coupons = couponRepository.findByCouponsType(coupon);

        CouponsDetails couponsDetails = new CouponsDetails(coupons.get(), user);
        couponDetailsRepository.save(couponsDetails);

        Double discountPrice = (totalPrice - coupons.get().discountPrice) < 0 ? 0 : (totalPrice - coupons.get().discountPrice);
        return discountPrice;
    }
}