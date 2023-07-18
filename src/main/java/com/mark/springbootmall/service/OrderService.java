package com.mark.springbootmall.service;

import com.mark.springbootmall.dto.CreateOrderRequest;
import com.mark.springbootmall.model.Order;

public interface OrderService {

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    Order getOrderById(Integer orderId);
}
