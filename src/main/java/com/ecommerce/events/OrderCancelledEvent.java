package com.ecommerce.events;

/**
 * Event triggered when an order is cancelled.
 */
public class OrderCancelledEvent extends Event {
    private final String reason;
    private final String cancelledBy;
    private final boolean refundRequired;

    public OrderCancelledEvent(String orderId, String reason, String cancelledBy, boolean refundRequired) {
        super(orderId, EventType.ORDER_CANCELLED);
        this.reason = reason;
        this.cancelledBy = cancelledBy;
        this.refundRequired = refundRequired;
    }

    public String getReason() {
        return reason;
    }

    public String getCancelledBy() {
        return cancelledBy;
    }

    public boolean isRefundRequired() {
        return refundRequired;
    }
}
