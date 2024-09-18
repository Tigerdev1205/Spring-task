# Task Manager API

This is a Spring Boot application for managing tasks with the following REST API endpoints:

## Endpoints

- `GET /tasks`: Returns all tasks
- `GET /tasks/{id}`: Returns a task by its ID
- `POST /tasks`: Creates a new task
- `PUT /tasks/{id}`: Updates an existing task

## How to Run

1. Clone the repository.
2. Navigate to the project root.
3. Run the following command:
   ./mvnw spring-boot:run
4. The application will be available at `http://localhost:8080`.

## Sample Task JSON

```json
{
  "title": "New Task",
  "description": "Description of the task",
  "completed": false
}
```
