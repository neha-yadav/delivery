package com.imitation.delivery.deliveryPerson.controller;

import com.imitation.delivery.deliveryPerson.model.DeliveryPerson;
import com.imitation.delivery.deliveryPerson.service.DeliveryPersonService;
import com.imitation.delivery.generic.controller.DefaultController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/deliveryPersons")
@RestController
public class DeliveryPersonController extends DefaultController<DeliveryPerson,DeliveryPersonService> {


    @GetMapping("/isActive")
    public List<DeliveryPerson> findAllActiveDeliveryPersons() {

        return service.findAllActiveDeliveryPersons();

    }

    @GetMapping("/isServing/{id}")
    public DeliveryPerson findAllServingOrders(@PathVariable Long id) {

        return service.findAllServingOrders(id);

    }

}
