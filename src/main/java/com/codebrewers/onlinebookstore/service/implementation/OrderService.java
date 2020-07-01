package com.codebrewers.onlinebookstore.service.implementation;

import com.codebrewers.onlinebookstore.exception.CartException;
import com.codebrewers.onlinebookstore.exception.UserServiceException;
import com.codebrewers.onlinebookstore.model.*;
import com.codebrewers.onlinebookstore.repository.*;
import com.codebrewers.onlinebookstore.service.IOrderService;
import com.codebrewers.onlinebookstore.utils.implementation.MailService;
import com.codebrewers.onlinebookstore.utils.implementation.Token;
import com.codebrewers.onlinebookstore.utils.templet.PlacedOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService implements IOrderService {

    @Autowired
    Token jwtToken;
    @Autowired
    MailService mailService;
    @Autowired
    IOrderRepository orderRepository;
    @Autowired
    IBookCartDetailsRepository cartDetailsRepository;
    @Autowired
    IBookStoreRepository bookStoreRepository;
    @Autowired
    IUserRepository userRepository;
    @Autowired
    ICustomerDetailsRepository customerDetailsRepository;
    @Autowired
    ICartRepository cartRepository;

    @Autowired
    PlacedOrder placedOrder;


    @Override
    public Integer placeOrder(Double totalPrice,Double discountPrice, String token) throws MessagingException {
        Integer orderId = generatedOrderId();
        CartDetails cart = getCart(token);
        List<BookCartDetails> cartBooks = cartDetailsRepository.fetchCartItems(cart.getId());
        CustomerDetails customerDetails = customerDetailsRepository.findByUserDetailsOrderById(cart.getUserDetails()).get(0);
        OrderDetails order = new OrderDetails(cart, orderId, cart.getUserDetails(), totalPrice, customerDetails, cartBooks);
        OrderDetails saveOrder = orderRepository.save(order);
        cartBooks.forEach(cartBook ->{
            cartBook.setOrderDetails(order);
            bookStoreRepository.updateBookQuantity(cartBook.getBookDetails().id, cartBook.getQuantity());
        });
        cartDetailsRepository.updateOrderPlacedStatus(cart.getId());

        String body = placedOrder.getHeader(cart,orderId,totalPrice,cartBooks,discountPrice);

        mailService.sendMail(body,"Order Placed",cart.userDetails.emailID);
        return saveOrder.getOrderId();
    }

    private int generatedOrderId(){
        boolean isUnique = false;
        Integer orderId = 0;
        while(!isUnique){
            orderId = (int) Math.floor(100000 + Math.random() * 999999);
            Optional<OrderDetails> byId = orderRepository.findByOrderId(orderId);
            if( !byId.isPresent())
                isUnique = true;
        }
        return orderId;
    }

    private CartDetails getCart(String token) {
        int userId = jwtToken.decodeJWT(token);
        UserDetails userDetails = userRepository.findById(userId)
                .orElseThrow(() -> new UserServiceException("User Not Exist"));
        return cartRepository.findByUserDetails(userDetails)
                .orElseThrow(() -> new CartException("Cart Not Found"));
    }

    @Override
    public List<BookCartDetails> fetchOrders(String token) {
        int userId = jwtToken.decodeJWT(token);
        UserDetails userDetails = userRepository.findById(userId)
                .orElseThrow(() -> new UserServiceException("User Not Exist"));
        List<OrderDetails> orderDetailsByUser = orderRepository.findOrderDetailsByUser(userDetails);
        List bookCartDetailsByOrderDetails=new ArrayList();
        List<BookCartDetails> bookCartDetailsByOrderDetails1=new ArrayList();
        for (OrderDetails order : orderDetailsByUser) {
            OrderDetails byId = orderRepository.findById(order.id).get();
            bookCartDetailsByOrderDetails1 = cartDetailsRepository.findBookCartDetailsByOrderDetails(byId);
            bookCartDetailsByOrderDetails.add(bookCartDetailsByOrderDetails1);
        }
        return bookCartDetailsByOrderDetails;
    }

}
