package com.imitation.delivery.dispatchOrder.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDeliveryRequest {

    @NotNull
    private Long orderId;

    @NotNull
    private Long deliveryPersonId;
}
