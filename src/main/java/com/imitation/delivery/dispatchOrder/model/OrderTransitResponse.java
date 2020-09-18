package com.imitation.delivery.dispatchOrder.model;

import com.imitation.delivery.order.model.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderTransitResponse {

    private Order orderDetails;

    private String timeLeftForDelivery;
}
