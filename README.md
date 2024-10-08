# Task Manager API

This is a Spring Boot application for managing tasks, designed to handle CRUD operations. You can use this API to create, read, update, and delete tasks. It's designed for developers who need a simple task management system with REST API endpoints:

## Endpoints

- `GET /tasks`: Returns all tasks
- `GET /tasks/{id}`: Returns a task by its ID
- `POST /tasks`: Creates a new task
- `PUT /tasks/{id}`: Updates an existing task

## Prerequisites

- Java 21
- Maven 3.9.5 installed or use the included Maven wrapper (`./mvnw`)

## How to Run

1. Clone the repository.
2. Navigate to the project root.
3. Run the following command:

```bash
   ./mvnw spring-boot:run
```

4. The application will be available at `http://localhost:8080`.

## Sample Task JSON

```json
{
  "title": "New Task",
  "description": "Description of the task",
  "completed": false
}
```

## Running Tests

Run the tests with:

```bash
./mvnw test
```

## Testing the API

You can use tools like Postman or curl to test the endpoints.

1. Create a task.

```bash
curl -X POST http://localhost:8080/tasks -H "Content-Type: application/json" -d "{\"title\":\"Task 1\", \"description\":\"First Task\", \"completed\":false}"
```

2. Get all tasks.

```bash
curl http://localhost:8080/tasks
```

3. Get task by ID.

```bash
curl http://localhost:8080/tasks/id
```

4. Update a task.

```bash
curl -X PUT http://localhost:8080/tasks/id -H "Content-Type: application/json" -d "{\"title\":\"Updated Task 1\", \"description\":\"Updated Description\", \"completed\":true}"
```
