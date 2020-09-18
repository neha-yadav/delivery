package com.imitation.delivery.dispatchOrder.service;

import com.imitation.delivery.deliveryPerson.model.DeliveryPerson;
import com.imitation.delivery.deliveryPerson.service.DeliveryPersonService;
import com.imitation.delivery.dispatchOrder.model.OrderDeliveryRequest;
import com.imitation.delivery.dispatchOrder.model.OrderDeliveryResponse;
import com.imitation.delivery.order.model.Order;
import com.imitation.delivery.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class OrderDeliveryService {

    @Autowired
    DeliveryPersonService deliveryPersonService;

    @Autowired
    OrderService orderService;


    public OrderDeliveryResponse assignDeliveryPersonIfAvailable(OrderDeliveryRequest orderDeliveryRequest){

        DeliveryPerson deliveryPerson = deliveryPersonService.findOne(orderDeliveryRequest.getDeliveryPersonId());
        if(deliveryPerson.isActive() &&  DeliveryPerson.Status.UNASSIGNED.equals(deliveryPerson.getStatus())){

            Order order = orderService.findOne(orderDeliveryRequest.getOrderId());
            if(Order.Status.INITIATED.equals(order.getStatus())){
                order.setStatus(Order.Status.PROCESSING);
                order.setDeliveryPerson(deliveryPerson);
                order.setDeliveryStartDateTime(LocalDateTime.now());
                orderService.save(order);
                deliveryPerson.setStatus(DeliveryPerson.Status.ASSIGNED);
                deliveryPersonService.save(deliveryPerson);
                return OrderDeliveryResponse.builder().status(OrderDeliveryResponse.Status.ACCEPTED).build();
            }
        }

        return OrderDeliveryResponse.builder().status(OrderDeliveryResponse.Status.REJECTED).build();
    }

}
