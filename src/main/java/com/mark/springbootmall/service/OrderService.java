package com.mark.springbootmall.service;

import com.mark.springbootmall.dto.CreateOrderRequest;
import com.mark.springbootmall.dto.OrderQueryParams;
import com.mark.springbootmall.model.Order;

import java.util.List;

public interface OrderService {

    Integer countOrder(OrderQueryParams orderQueryParams);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    Order getOrderById(Integer orderId);
}
