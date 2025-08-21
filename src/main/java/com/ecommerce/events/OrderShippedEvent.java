package com.ecommerce.events;

import java.time.LocalDateTime;

/**
 * Event triggered when an order is shipped.
 */
public class OrderShippedEvent extends Event {
    private final String shippingId;
    private final LocalDateTime shippedDate;
    private final String carrier;
    private final String trackingNumber;

    public OrderShippedEvent(String orderId, String shippingId, LocalDateTime shippedDate, 
                           String carrier, String trackingNumber) {
        super(orderId, EventType.ORDER_SHIPPED);
        this.shippingId = shippingId;
        this.shippedDate = shippedDate;
        this.carrier = carrier;
        this.trackingNumber = trackingNumber;
    }

    public String getShippingId() {
        return shippingId;
    }

    public LocalDateTime getShippedDate() {
        return shippedDate;
    }

    public String getCarrier() {
        return carrier;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }
}
