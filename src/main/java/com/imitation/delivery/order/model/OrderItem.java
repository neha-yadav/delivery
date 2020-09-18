package com.imitation.delivery.order.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imitation.delivery.generic.Model;
import com.imitation.delivery.order.service.ItemIdSerializer;
import com.imitation.delivery.order.service.OrderIdSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "order_items")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem implements Model {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonSerialize(using = ItemIdSerializer.class)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Item item;

    @JsonSerialize(using = OrderIdSerializer.class)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Order order;

    @NotNull
    @Min(value = 1)
    private int quantity;

}
