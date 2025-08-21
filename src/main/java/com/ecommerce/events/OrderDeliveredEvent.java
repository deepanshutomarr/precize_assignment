package com.ecommerce.events;

import java.time.LocalDateTime;

/**
 * Event triggered when an order is delivered.
 */
public class OrderDeliveredEvent extends Event {
    private final LocalDateTime deliveredDate;
    private final String deliveredTo;
    private final String signature;

    public OrderDeliveredEvent(String orderId, LocalDateTime deliveredDate, 
                             String deliveredTo, String signature) {
        super(orderId, EventType.ORDER_DELIVERED);
        this.deliveredDate = deliveredDate;
        this.deliveredTo = deliveredTo;
        this.signature = signature;
    }

    public LocalDateTime getDeliveredDate() {
        return deliveredDate;
    }

    public String getDeliveredTo() {
        return deliveredTo;
    }

    public String getSignature() {
        return signature;
    }
}
