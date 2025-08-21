# Event-Driven Order Processing System

A simplified, event-driven order processing system in Java, simulating the backend of an e-commerce platform. This system processes various order-related events and maintains order state through an observer pattern for notifications.

## 🎯 Objective

Design and implement a backend system that processes various order-related events such as:
- Order creation
- Payment receipt
- Shipping scheduling
- Order cancellation

Each event type triggers corresponding logic and updates within the system. Additionally, observers are notified of significant changes (e.g., status updates).

## 🏗️ Architecture

The system is built using the following design patterns and components:

### Core Components

1. **Domain Model**
   - `Order` class with attributes: orderId, customerId, items, totalAmount, status, and eventHistory
   - `OrderStatus` enum defining all possible order states
   - `OrderItem` class representing individual items in an order

2. **Event System**
   - Base `Event` abstract class with common fields: eventId, timestamp, and eventType
   - Concrete event types:
     - `OrderCreatedEvent` (includes order details)
     - `PaymentReceivedEvent` (includes orderId, amount paid)
     - `ShippingScheduledEvent` (includes orderId, shipping date)
     - `OrderCancelledEvent` (includes orderId, reason)
     - `OrderShippedEvent` (includes shipping details)
     - `OrderDeliveredEvent` (includes delivery details)

3. **Event Ingestion**
   - `EventIngestionService` for reading events from JSON files
   - `EventParser` for parsing JSON events into Event objects
   - Support for one JSON object per line format

4. **Event Processing**
   - `EventProcessor` component to process events and update Order states
   - Specific logic per event type:
     - `OrderCreatedEvent`: Create a new Order with status PENDING
     - `PaymentReceivedEvent`: Update status to PAID if payment matches totalAmount
     - `ShippingScheduledEvent`: Update status to PROCESSING
     - `OrderCancelledEvent`: Update status to CANCELLED
     - Graceful handling of unknown event types

5. **Observer Pattern**
   - `OrderObserver` interface for event notifications
   - `OrderSubject` interface for managing observers
   - `OrderEventManager` implementation
   - Two concrete observers:
     - `LoggingOrderObserver`: Logs events and status changes to console
     - `AlertOrderObserver`: Prints alerts for critical changes

## 📁 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── ecommerce/
│   │           ├── events/
│   │           │   ├── Event.java
│   │           │   ├── EventType.java
│   │           │   ├── OrderCreatedEvent.java
│   │           │   ├── PaymentReceivedEvent.java
│   │           │   ├── ShippingScheduledEvent.java
│   │           │   ├── OrderCancelledEvent.java
│   │           │   ├── OrderShippedEvent.java
│   │           │   ├── OrderDeliveredEvent.java
│   │           │   ├── OrderItem.java
│   │           │   ├── EventParser.java
│   │           │   ├── EventParseException.java
│   │           │   └── EventIngestionService.java
│   │           ├── order/
│   │           │   ├── Order.java
│   │           │   └── OrderStatus.java
│   │           ├── observer/
│   │           │   ├── OrderObserver.java
│   │           │   ├── OrderSubject.java
│   │           │   ├── OrderEventManager.java
│   │           │   ├── LoggingOrderObserver.java
│   │           │   └── AlertOrderObserver.java
│   │           ├── processor/
│   │           │   └── EventProcessor.java
│   │           └── OrderProcessingSystem.java
│   └── resources/
│       └── sample_events.json
├── test/
└── pom.xml
```

## 🚀 Getting Started

### Prerequisites

- Java 11 or higher
- Maven 3.6 or higher

### Installation

1. Clone the repository:
```bash
git clone <repository-url>
cd order-processing-system
```

2. Build the project:
```bash
mvn clean compile
```

3. Run the application:
```bash
mvn exec:java -Dexec.mainClass="com.ecommerce.OrderProcessingSystem"
```

Or run the JAR file:
```bash
mvn package
java -jar target/order-processing-system-1.0.0.jar
```

## 📝 Usage

### Sample Events Format

The system reads events from JSON files with one JSON object per line:

```json
{"eventId": "e1", "timestamp": "2025-01-29T10:00:00Z", "eventType": "OrderCreated", "orderId": "ORD001", "customerId": "CUST001", "items": [{"itemId": "P001", "productName": "Laptop", "qty": 2, "unitPrice": 50.00}], "totalAmount": 100.00, "shippingAddress": "123 Main St, City, State 12345"}
{"eventId": "e2", "timestamp": "2025-01-29T10:05:00Z", "eventType": "PaymentReceived", "orderId": "ORD001", "paymentId": "PAY001", "amount": 100.00, "paymentMethod": "Credit Card", "transactionId": "TXN001"}
```

### Programmatic Usage

```java
// Create the system
OrderProcessingSystem system = new OrderProcessingSystem();

// Process events from a file
int processedCount = system.processEventsFromFile("path/to/events.json");

// Get an order
Order order = system.getOrder("ORD001");

// Register a custom observer
system.registerObserver(new CustomOrderObserver());
```

## 🔧 Configuration

### Event Types Supported

- `OrderCreated`: Creates a new order
- `PaymentReceived`: Processes payment for an order
- `ShippingScheduled`: Schedules shipping for an order
- `OrderCancelled`: Cancels an order
- `OrderShipped`: Marks an order as shipped
- `OrderDelivered`: Marks an order as delivered

### Order Statuses

- `CREATED`: Order has been created
- `PENDING_PAYMENT`: Waiting for payment
- `PAID`: Payment received
- `PROCESSING`: Order is being processed
- `SHIPPED`: Order has been shipped
- `DELIVERED`: Order has been delivered
- `CANCELLED`: Order has been cancelled

## 🧪 Testing

Run the tests:
```bash
mvn test
```

## 📊 Sample Output

When running the system with the sample events, you'll see output like:

```
🚀 Starting Event-Driven Order Processing System
================================================

💰 PAYMENT ALERT: Payment received for Order ORD001
   Amount: $100.00

📦 SHIPPING ALERT: Order ORD001 has been SHIPPED!
   Tracking: FX123456789

🚨 CRITICAL ALERT: Order ORD002 has been CANCELLED!
   Customer: CUST002
   Total Amount: $25.00

📊 Processing Summary:
Processed 5 events successfully

📋 Current Orders:
Order ID: ORD001
  Customer: CUST001
  Status: SHIPPED
  Total: $100.00
  Items: 1
  Payment ID: PAY001
  Tracking: FX123456789

Order ID: ORD002
  Customer: CUST002
  Status: CANCELLED
  Total: $25.00
  Items: 1
  Payment ID: N/A
  Tracking: N/A

✅ System demonstration completed!
```

## 🔍 Key Features

1. **Event-Driven Architecture**: All order state changes are triggered by events
2. **Observer Pattern**: Multiple observers can be notified of order changes
3. **JSON Event Ingestion**: Read events from simple JSON files
4. **Graceful Error Handling**: Unknown event types are logged as warnings
5. **Thread-Safe**: Uses concurrent collections for thread safety
6. **Extensible**: Easy to add new event types and observers

## 🛠️ Extending the System

### Adding New Event Types

1. Create a new event class extending `Event`
2. Add the event type to `EventType` enum
3. Update `EventParser` to handle the new event type
4. Update `EventProcessor` to process the new event

### Adding New Observers

1. Implement the `OrderObserver` interface
2. Register the observer with the `OrderEventManager`
