,🎬 CineVault – Distributed Dynamic Movie Ticket Booking System
A production-oriented distributed backend system implementing seat-level booking, dynamic pricing logic, service discovery, API gateway routing, and client-side load balancing using Spring Boot and Spring Cloud.
🏗 Architecture Overview
CineVault is a multi-module Maven microservices application where each service is independently deployable and owns its own database.
The system is built using:
Spring Boot
Spring Cloud Eureka (Service Discovery)
Spring Cloud Gateway (Centralized Routing)
OpenFeign (Inter-service Communication)
Spring Cloud LoadBalancer (Round-Robin Strategy)
MySQL (Database per Service Architecture)
This design ensures loose coupling, independent scalability, and service-level fault isolation.
🧩 Microservices
Service
Responsibility
Database
movie-service
Movie catalog management
movie_db
show-service
Show scheduling & seat management
show_db
booking-service
Distributed booking & pricing engine
booking_db
user-service
User management
user_db
theatre-service
Theatre & screen management
theatre_db
api-gateway
Centralized request routing
—
eureka-server
Service registry
—
🚀 Core Features
🔹 Business Features
Seat-level booking system
Double booking prevention logic
Dynamic pricing engine:
VIP → 1.5x multiplier
Premium → 1.2x multiplier
Weekend surcharge (+20%)
Morning discount (-10%)
Revenue calculation and aggregation
🔹 Engineering Features
Database-per-service architecture
Service discovery via Eureka
API Gateway routing layer
Feign-based inter-service communication
Client-side load balancing (Round Robin)
Centralized exception handling
Clean layered architecture (Controller → Service → Repository)
🔄 Distributed Booking Workflow
Request received via API Gateway
booking-service invokes show-service using Feign
Seat availability validated
Dynamic pricing rules applied
Seats marked as booked
Booking persisted in booking database
Business logic from the monolithic version is preserved while adapting to distributed communication.
⚖ Monolith vs Microservices
Monolith
Microservices
Single deployable unit
Multiple independent services
Shared database
Database per service
Direct method calls
REST-based inter-service communication
No service registry
Eureka-based discovery
No load balancing
Client-side load balancing
Limited scalability
Independent service scaling
▶ How to Run
Start eureka-server
Start all microservices
Start api-gateway
Access endpoints via gateway:
Copy code

http://localhost:8080/movie-service/movies
http://localhost:8080/booking-service/bookings
📌 Project Evolution
This project is the distributed microservices evolution of the original CineVault monolithic booking system, preserving core business rules while improving scalability and architectural maturity.
