# vector-service-java

A lightweight Java + Spring Boot service that serves vector embeddings for content IDs — simulating real-world personalization and content discovery infrastructure, similar to systems used at Pinterest.

## Features

- Java + Spring Boot REST API  
- In-memory retrieval of mock content embeddings  
- Clean Maven build structure  
- Easily extensible for recommendation or search applications

## API Example

**Request:**

```
GET /embedding/plant_decor_pin
```

**Response:**

```json
{
  "contentId": "plant_decor_pin",
  "vector": [0.12, 0.34, 0.56, 0.78]
}
```

## How to Run

1. **Install Java 17+ and Maven**

2. **Clone this repository**

   ```bash
   git clone https://github.com/edilchristian/vector-service-java.git
   cd vector-service-java
   ```

3. **Run the service**

   ```bash
   mvn spring-boot:run
   ```

   The API will be available at:

   ```
   http://localhost:8080
   ```

## Context

This project simulates how vector embeddings might be served in real-world systems for use cases such as:

- Personalized content feeds  
- Visual search infrastructure  
- Content similarity and clustering  
- Retrieval-augmented generation (RAG) workflows

In real systems, vector dimensions are often 128D, 256D, or even 768D (e.g. BERT-based encodings). This service is designed to simulate that retrieval layer in a minimal, standalone way.

## Project Structure

```
src/
├── main/
│   ├── java/com/example/vectorservice/
│   │   ├── controller/
│   │   └── service/
│   └── resources/
│       └── mock_embeddings.json
pom.xml
```

---

Created by [@edilchristian](https://github.com/edilchristian)

