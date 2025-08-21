package com.ecommerce.observer;

import com.ecommerce.events.Event;
import com.ecommerce.order.Order;

/**
 * Observer interface for order-related events.
 * Implementations will be notified when order events occur.
 */
public interface OrderObserver {
    
    /**
     * Called when an order event occurs.
     * 
     * @param order the order that was affected
     * @param event the event that occurred
     */
    void onOrderEvent(Order order, Event event);
    
    /**
     * Called when an order status changes.
     * 
     * @param order the order whose status changed
     * @param oldStatus the previous status
     * @param newStatus the new status
     */
    void onOrderStatusChanged(Order order, String oldStatus, String newStatus);
}
