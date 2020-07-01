package com.codebrewers.onlinebookstore.controller;

import com.codebrewers.onlinebookstore.dto.ResponseDTO;
import com.codebrewers.onlinebookstore.model.BookCartDetails;
import com.codebrewers.onlinebookstore.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@CrossOrigin
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<ResponseDTO>  placeOrder(@RequestParam(name = "totalprice") Double totalPrice,@RequestParam(name = "discountPrice") Double discountPrice, @RequestHeader(value = "token",required = false) String token) throws MessagingException {
        Integer orderId = orderService.placeOrder(totalPrice,discountPrice,token);
        ResponseDTO response = new ResponseDTO("Order Placed Successfully", orderId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/order")
    public ResponseEntity fetchOrderSummary(@RequestHeader(value = "token",required = false) String token) {
        List<BookCartDetails> orders = orderService.fetchOrders(token);
        ResponseDTO response = new ResponseDTO("Order Data Fetched Successfully", orders);
        return new ResponseEntity(response, HttpStatus.OK);
    }

}
