package com.imitation.delivery.deliveryPerson.service;

import com.imitation.delivery.deliveryPerson.model.DeliveryPerson;
import com.imitation.delivery.deliveryPerson.model.DeliveryPersonRepository;
import com.imitation.delivery.generic.service.DefaultService;
import com.imitation.delivery.order.model.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeliveryPersonService extends DefaultService<DeliveryPerson,DeliveryPersonRepository> {

     Specification<DeliveryPerson> isActive() {
        return (deliveryPerson, cq, cb) -> cb.equal(deliveryPerson.get("active"), true);
    }

    public List<DeliveryPerson> findAllActiveDeliveryPersons(){
        return repository.findAll(isActive());
    }

    public DeliveryPerson findAllServingOrders(Long id){
        DeliveryPerson deliveryPerson = repository.findById(id).get();
        List<Order> orders = deliveryPerson.getOrders().stream().filter(x->x.getStatus().equals(Order.Status.PROCESSING)).collect(Collectors.toList());
        deliveryPerson.setOrders(orders);
        return deliveryPerson;
    }
}
