# Movie Recommendation and Review System

Java 17 Spring Boot API with PostgreSQL and a Python FastAPI microservice that returns recommendations. Everything runs with Docker Compose.

## Run

docker compose up --build

API base URL  
http://localhost:8080

Example endpoints  
GET /api/movies  
POST /api/reviews  
GET /api/reviews/movie/{movieId}  
GET /api/recommendations/{userId}?limit=5
