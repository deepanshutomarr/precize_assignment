package com.ecommerce.order;

/**
 * Enumeration of all possible order statuses.
 */
public enum OrderStatus {
    CREATED("Order has been created"),
    PENDING_PAYMENT("Waiting for payment"),
    PAID("Payment received"),
    PROCESSING("Order is being processed"),
    SHIPPED("Order has been shipped"),
    DELIVERED("Order has been delivered"),
    CANCELLED("Order has been cancelled");

    private final String description;

    OrderStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
