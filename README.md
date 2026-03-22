🎬 CineVault – Distributed Full Stack Movie Ticket Booking System

A production-style full stack microservices application that simulates a real-world movie ticket booking platform using Spring Boot + React.

It demonstrates distributed system design, API Gateway routing, service discovery, and end-to-end booking flow from UI to database.

---

🚀 Overview

CineVault is designed as a scalable, loosely coupled system where each service operates independently and communicates via REST APIs.

The system includes:

- Backend: Spring Boot Microservices
- Frontend: React (UI for booking flow)
- Communication: API Gateway + Feign
- Service Discovery: Eureka
- Database: MySQL (per service)

---

🧠 Tech Stack

Backend

- Java
- Spring Boot
- Spring Cloud (Eureka, Gateway)
- OpenFeign
- MySQL

Frontend

- React (Functional Components)
- JavaScript (ES6)
- HTML5, CSS3

---

🏗 Architecture Overview

CineVault follows a microservices architecture:

- API Gateway for centralized routing
- Eureka Server for service discovery
- Independent services with their own databases
- Feign clients for inter-service communication

---

🏗 Architecture Diagram

flowchart TD

    Client[Client<br/>Browser / Postman]

    Gateway[API Gateway<br/>Spring Cloud Gateway<br/>Port 8080]

    Eureka[Eureka Server<br/>Service Registry<br/>Port 8761]

    Movie[movie-service]
    Show[show-service]
    Booking[booking-service]
    User[user-service]
    Theatre[theatre-service]

    MovieDB[(movie_db)]
    ShowDB[(show_db)]
    BookingDB[(booking_db)]
    UserDB[(user_db)]
    TheatreDB[(theatre_db)]

    Client --> Gateway

    Gateway --> Movie
    Gateway --> Show
    Gateway --> Booking
    Gateway --> User
    Gateway --> Theatre

    Movie --> MovieDB
    Show --> ShowDB
    Booking --> BookingDB
    User --> UserDB
    Theatre --> TheatreDB

    Movie -.-> Eureka
    Show -.-> Eureka
    Booking -.-> Eureka
    User -.-> Eureka
    Theatre -.-> Eureka

    Booking -->|Feign Call<br/>Seat Validation & Pricing| Show

---

📌 Architecture Explanation

- All requests go through API Gateway (single entry point)
- Services dynamically discovered using Eureka
- Each service owns its database (Database per Service pattern)
- booking-service validates seats using show-service via Feign
- Designed for scalability and loose coupling

---

🖥️ Frontend (React Integration)

A lightweight React frontend demonstrates the complete booking flow.

Features

- Fetch movies from backend
- View shows by movie
- Seat selection UI (Available / Booked)
- Booking integration with backend APIs
- Uses API Gateway for all requests

🔄 Flow

Movies → Shows → Seats → Booking

---

📸 System Proof Screenshots

🔹 Eureka Dashboard (All Services Registered)

"Eureka" (screenshots/eureka-dashboard.png)

🔹 API Gateway Routing via Postman

"Gateway" (screenshots/gateway-routing.png)

---

🎥 Frontend Screenshots

🎬 Movies Page

"Movies" (screenshots/movies.png)

🎭 Shows Page

"Shows" (screenshots/shows.png)

💺 Seat Selection

"Seats" (screenshots/seats.png)

✅ Booking Success (Valid Selection)

"Booking Success" (screenshots/success_msg.png)

⚠️ Validation Error (No Seats Selected)

"Validation Error" (screenshots/alert_msg.png)

👉 These screenshots demonstrate the complete end-to-end booking flow from UI to microservices backend, including both success and validation scenarios.

---

🧩 Microservices

Service| Responsibility| Database
movie-service| Manage movies| movie_db
show-service| Manage shows & seats| show_db
booking-service| Booking logic & pricing| booking_db
user-service| Manage users| user_db
theatre-service| Manage theatres| theatre_db
api-gateway| Routing layer| —
eureka-server| Service registry| —

---

🚀 Key Features

🔹 Business Logic

- Seat-level booking
- Double booking prevention
- Dynamic pricing engine
- Weekend surge pricing (+20%)
- Morning discount (-10%)
- VIP/Premium seat pricing

🔹 Engineering Highlights

- Microservices architecture
- Database-per-service pattern
- API Gateway routing
- Feign communication
- Client-side load balancing
- Centralized exception handling

---

🔄 Booking Flow (Distributed)

1. Request hits API Gateway
2. booking-service calls show-service via Feign
3. Seat availability validated
4. Dynamic pricing applied
5. Seats marked as booked
6. Booking stored in database

---

🆚 Monolith vs Microservices

Monolith| Microservices
Single codebase| Multiple independent services
Shared database| Database per service
Direct method calls| REST + Feign communication
No service discovery| Eureka-based discovery
Hard to scale selectively| Individual service scaling

---

⚙️ How to Run Locally

1. Start eureka-server
2. Start all microservices
3. Start api-gateway
4. Run frontend:

cd frontend
npm install
npm start

---

💡 Key Learnings

- Built scalable distributed system using Spring Boot
- Implemented API Gateway & service discovery
- Designed real-world booking workflow
- Integrated React frontend with microservices backend
- Applied production-level architecture patterns

---

📌 Future Enhancements

- JWT Authentication
- Payment integration
- React Router navigation
- Docker & Kubernetes deployment

---

🚀 This project demonstrates fullstack capability, distributed system design, and real-world backend architecture.