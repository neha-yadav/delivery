package com.imitation.delivery.dispatchOrder.controller;

import com.imitation.delivery.dispatchOrder.model.OrderDeliveryRequest;
import com.imitation.delivery.dispatchOrder.model.OrderDeliveryResponse;
import com.imitation.delivery.dispatchOrder.service.OrderDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/orderDelivery")
@RestController
public class OrderDeliveryController {

    @Autowired
    OrderDeliveryService orderDeliveryService;

    @PostMapping("/delegate")
    public OrderDeliveryResponse assignDeliveryPerson(@RequestBody OrderDeliveryRequest orderDeliveryRequest) {

        return orderDeliveryService.assignDeliveryPersonIfAvailable(orderDeliveryRequest);

    }

}
