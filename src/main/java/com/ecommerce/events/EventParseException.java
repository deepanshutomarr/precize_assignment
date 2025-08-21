package com.ecommerce.events;

/**
 * Exception thrown when event parsing fails.
 */
public class EventParseException extends Exception {
    
    public EventParseException(String message) {
        super(message);
    }
    
    public EventParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
