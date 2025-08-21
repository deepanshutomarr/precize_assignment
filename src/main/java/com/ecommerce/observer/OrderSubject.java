package com.ecommerce.observer;

/**
 * Subject interface for the observer pattern.
 * Defines methods to register, unregister, and notify observers.
 */
public interface OrderSubject {
    
    /**
     * Register an observer to receive notifications.
     * 
     * @param observer the observer to register
     */
    void registerObserver(OrderObserver observer);
    
    /**
     * Unregister an observer from receiving notifications.
     * 
     * @param observer the observer to unregister
     */
    void unregisterObserver(OrderObserver observer);
    
    /**
     * Notify all registered observers of an order event.
     * 
     * @param order the order that was affected
     * @param event the event that occurred
     */
    void notifyObservers(com.ecommerce.order.Order order, com.ecommerce.events.Event event);
    
    /**
     * Notify all registered observers of an order status change.
     * 
     * @param order the order whose status changed
     * @param oldStatus the previous status
     * @param newStatus the new status
     */
    void notifyStatusChange(com.ecommerce.order.Order order, String oldStatus, String newStatus);
}
