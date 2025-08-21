package com.ecommerce.events;

import java.time.LocalDateTime;

/**
 * Event triggered when shipping is scheduled for an order.
 */
public class ShippingScheduledEvent extends Event {
    private final String shippingId;
    private final LocalDateTime scheduledDate;
    private final String carrier;
    private final String trackingNumber;
    private final String shippingMethod;

    public ShippingScheduledEvent(String orderId, String shippingId, LocalDateTime scheduledDate, 
                                String carrier, String trackingNumber, String shippingMethod) {
        super(orderId, EventType.SHIPPING_SCHEDULED);
        this.shippingId = shippingId;
        this.scheduledDate = scheduledDate;
        this.carrier = carrier;
        this.trackingNumber = trackingNumber;
        this.shippingMethod = shippingMethod;
    }

    public String getShippingId() {
        return shippingId;
    }

    public LocalDateTime getScheduledDate() {
        return scheduledDate;
    }

    public String getCarrier() {
        return carrier;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }
}
