package com.codebrewers.onlinebookstore.controller;

import com.codebrewers.onlinebookstore.dto.ResponseDTO;
import com.codebrewers.onlinebookstore.model.Coupons;
import com.codebrewers.onlinebookstore.service.ICouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CouponController {

    @Autowired
    ICouponService couponService;

    @GetMapping("/coupon")
    public ResponseEntity fetchOrderCoupon(@RequestHeader(value = "token", required = false) String token,@RequestParam(name = "totalPrice") Double totalPrice) {
        List<Coupons> orders = couponService.fetchCoupon(token,totalPrice);
        ResponseDTO response = new ResponseDTO("Coupons Fetched Successfully", orders);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PostMapping("/coupon")
    public ResponseEntity addCoupon(@RequestHeader(value = "token",required = false) String token,@RequestParam(name = "discountCoupon",defaultValue = "0") String coupon, @RequestParam(name = "totalPrice") Double totalPrice){
        Double coupon1 = couponService.addCoupon(token, coupon, totalPrice);
        ResponseDTO responseDTO = new ResponseDTO("Coupon added successfully",coupon1);
        return new ResponseEntity(responseDTO,HttpStatus.OK);
    }

}
