# **Implementation Plan: Supply Chain Management System**

## **1️⃣ Order Management Service**
### **Database Schema (PostgreSQL)**
- `orders (id, customer_id, product_id, quantity, status, created_at, updated_at)`
- `order_items (id, order_id, product_id, quantity, price)`

### **Key REST Endpoints**
- `POST /orders` → Create new order
- `GET /orders/{id}` → Fetch order details
- `PUT /orders/{id}/status` → Update order status
- `GET /orders/customer/{customerId}` → Get customer orders

### **Inter-Service Communication**
- Calls Inventory Service to check product availability.
- Emits order status events via Kafka for the Shipment Service.

---

## **2️⃣ Inventory Management Service**
### **Database Schema (PostgreSQL)**
- `products (id, name, stock, warehouse_id, price)`
- `warehouses (id, location, capacity)`

### **Key REST Endpoints**
- `GET /inventory/{productId}` → Check stock
- `POST /inventory/restock` → Update stock levels
- `PUT /inventory/order-update` → Reduce stock on order confirmation

### **Inter-Service Communication**
- Listens to Order Service events to decrement stock.
- Publishes stock updates to Kafka for real-time monitoring.

---

## **3️⃣ Shipment & Logistics Service**
### **Database Schema (MongoDB)**
- `shipments (id, order_id, tracking_id, status, expected_delivery, location)`

### **Key REST Endpoints**
- `POST /shipments/initiate` → Start shipment for an order
- `GET /shipments/{trackingId}` → Track shipment status
- `PUT /shipments/{trackingId}/update` → Update delivery status

### **Inter-Service Communication**
- Subscribes to Order Service to initiate shipments.
- Uses Redis for fast tracking lookups.

---

## **4️⃣ User Service**
### **Database Schema (PostgreSQL)**
- `users (id, name, email, password, role)`

### **Key REST Endpoints**
- `POST /users/register` → Register new user
- `POST /users/login` → Authenticate user and return JWT
- `GET /users/{id}` → Fetch user details

### **Inter-Service Communication**
- Provides JWT authentication for other services.
- Ensures authorized access to order history and account details.

---

## **Security & Authentication**
- Uses **Spring Security** for authentication and authorization.
- Implements **JWT** for securing API endpoints.
- API Gateway enforces authentication for all services.
