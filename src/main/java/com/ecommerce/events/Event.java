package com.ecommerce.events;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Base class for all events in the order processing system.
 * Provides common properties like event ID, timestamp, and order ID.
 */
public abstract class Event {
    private final String eventId;
    private final String orderId;
    private final LocalDateTime timestamp;
    private final EventType eventType;

    public Event(String orderId, EventType eventType) {
        this.eventId = UUID.randomUUID().toString();
        this.orderId = orderId;
        this.timestamp = LocalDateTime.now();
        this.eventType = eventType;
    }

    public String getEventId() {
        return eventId;
    }

    public String getOrderId() {
        return orderId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public EventType getEventType() {
        return eventType;
    }

    @Override
    public String toString() {
        return String.format("%s{eventId='%s', orderId='%s', timestamp=%s}", 
            getClass().getSimpleName(), eventId, orderId, timestamp);
    }
}
