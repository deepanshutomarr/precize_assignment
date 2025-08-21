package com.ecommerce.events;

import java.math.BigDecimal;
import java.util.List;

/**
 * Event triggered when a new order is created.
 */
public class OrderCreatedEvent extends Event {
    private final String customerId;
    private final List<OrderItem> items;
    private final BigDecimal totalAmount;
    private final String shippingAddress;

    public OrderCreatedEvent(String orderId, String customerId, List<OrderItem> items, 
                           BigDecimal totalAmount, String shippingAddress) {
        super(orderId, EventType.ORDER_CREATED);
        this.customerId = customerId;
        this.items = items;
        this.totalAmount = totalAmount;
        this.shippingAddress = shippingAddress;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }
}
