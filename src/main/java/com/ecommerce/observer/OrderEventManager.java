package com.ecommerce.observer;

import com.ecommerce.events.Event;
import com.ecommerce.order.Order;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Manages order observers and notifies them of order-related events.
 * Implements the Observer pattern for order event notifications.
 */
public class OrderEventManager implements OrderSubject {
    
    private final List<OrderObserver> observers = new CopyOnWriteArrayList<>();
    
    @Override
    public void registerObserver(OrderObserver observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
        }
    }
    
    @Override
    public void unregisterObserver(OrderObserver observer) {
        observers.remove(observer);
    }
    
    @Override
    public void notifyObservers(Order order, Event event) {
        for (OrderObserver observer : observers) {
            try {
                observer.onOrderEvent(order, event);
            } catch (Exception e) {
                System.err.println("Error notifying observer " + observer.getClass().getSimpleName() + ": " + e.getMessage());
            }
        }
    }
    
    @Override
    public void notifyStatusChange(Order order, String oldStatus, String newStatus) {
        for (OrderObserver observer : observers) {
            try {
                observer.onOrderStatusChanged(order, oldStatus, newStatus);
            } catch (Exception e) {
                System.err.println("Error notifying observer " + observer.getClass().getSimpleName() + ": " + e.getMessage());
            }
        }
    }
    
    /**
     * Get the number of registered observers.
     * 
     * @return the number of observers
     */
    public int getObserverCount() {
        return observers.size();
    }
}
