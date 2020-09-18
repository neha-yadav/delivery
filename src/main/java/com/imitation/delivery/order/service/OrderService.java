package com.imitation.delivery.order.service;

import com.imitation.delivery.generic.service.DefaultService;
import com.imitation.delivery.order.model.Order;
import com.imitation.delivery.order.model.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends DefaultService<Order,OrderRepository> {

}
