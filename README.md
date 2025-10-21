Spring Boot Kafka Calculator

A simple Spring Boot application that demonstrates communication between two microservices — a REST API and a Calculator service — using Apache Kafka for asynchronous messaging.

🧩 Project Overview
This project consists of two main modules:

rest – Exposes HTTP endpoints and sends calculation requests via Kafka.

calculator – Listens to Kafka topics, performs arithmetic operations, and returns results.

🚀 How to Build and Run
1. Start Kafka Infrastructure

Make sure Docker Desktop is running, then start the Kafka environment from the project root:

docker-compose up -d

2. Build the Project

From the project root directory:

mvn clean install

3. Start the REST Module
cd rest
mvn spring-boot:run


The REST API will start on http://localhost:8080
.

4. Start the Calculator Module

Open a new terminal tab (from the project root):

cd calculator
mvn spring-boot:run


The Calculator service will start on http://localhost:8081
.

🔧 Usage
The REST API exposes the following endpoints:

Endpoint	Description
GET /sum?a={number}&b={number}	Addition
GET /subtraction?a={number}&b={number}	Subtraction
GET /multiplication?a={number}&b={number}	Multiplication
GET /division?a={number}&b={number}	Division
🧪 Example Requests

Use curl or your preferred API testing tool:

curl "http://localhost:8080/sum?a=1&b=2"
curl "http://localhost:8080/subtraction?a=10&b=3"
curl "http://localhost:8080/multiplication?a=4&b=6"
curl "http://localhost:8080/division?a=15&b=3"

🛠️ Tech Stack

Java 17+

Spring Boot

Apache Kafka

Maven

Docker / Docker Compose
