package com.imitation.delivery.dispatchOrder.model;

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
public class OrderDeliveryResponse {

    private Status status;

    public enum Status{

        ACCEPTED("ACCEPTED"),
        REJECTED("REJECTED");

        private final String value;

        Status(String v) {
            value = v;
        }

        public String toString() {
            return this.value;
        }
    }
}
