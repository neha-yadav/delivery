package com.imitation.delivery.deliveryPerson.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryPersonRepository extends JpaRepository<DeliveryPerson,Long> ,JpaSpecificationExecutor<DeliveryPerson> {
}
