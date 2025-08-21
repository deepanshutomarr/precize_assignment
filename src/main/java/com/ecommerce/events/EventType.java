package com.ecommerce.events;

/**
 * Enumeration of all event types in the order processing system.
 */
public enum EventType {
    ORDER_CREATED,
    PAYMENT_RECEIVED,
    SHIPPING_SCHEDULED,
    ORDER_CANCELLED,
    ORDER_SHIPPED,
    ORDER_DELIVERED
}
