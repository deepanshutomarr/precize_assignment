package com.ecommerce.events;

import java.math.BigDecimal;

/**
 * Event triggered when payment is received for an order.
 */
public class PaymentReceivedEvent extends Event {
    private final String paymentId;
    private final BigDecimal amount;
    private final String paymentMethod;
    private final String transactionId;

    public PaymentReceivedEvent(String orderId, String paymentId, BigDecimal amount, 
                              String paymentMethod, String transactionId) {
        super(orderId, EventType.PAYMENT_RECEIVED);
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.transactionId = transactionId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getTransactionId() {
        return transactionId;
    }
}
