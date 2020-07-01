package com.codebrewers.onlinebookstore.service;

import com.codebrewers.onlinebookstore.model.BookCartDetails;

import javax.mail.MessagingException;
import java.util.List;

public interface IOrderService {

    Integer placeOrder(Double totalPrice, Double discountPrice,String token) throws MessagingException;
    List<BookCartDetails> fetchOrders(String token);
}
