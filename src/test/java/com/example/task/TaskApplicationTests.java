package com.example.task;

import com.example.task.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TaskApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseUrl;

    @BeforeEach
    void setUp() {
        baseUrl = "http://localhost:" + port + "/tasks";
    }

    @Test
    void createTask() {
        Task task = new Task(null, "Test Task", "Testing Task Creation", false, new Date(), new Date());
        ResponseEntity<Task> responseEntity = restTemplate.postForEntity(baseUrl, task, Task.class);

        // Validate the response
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Task createdTask = responseEntity.getBody();
        assertThat(createdTask).isNotNull();
        assertThat(createdTask.getTitle()).isEqualTo("Test Task");
        assertThat(createdTask.getDescription()).isEqualTo("Testing Task Creation");
        assertThat(createdTask.getCompleted()).isFalse();
    }

    @Test
    void getAllTasks() {
        // Retrieve all tasks
         ResponseEntity<Task[]> responseEntity = restTemplate.getForEntity(baseUrl, Task[].class);

		// Validate the response
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		Task[] tasks = responseEntity.getBody();
		
		// Allow for an empty list if that's a valid state
		assertThat(tasks).isNotNull();
		assertThat(tasks.length).isGreaterThanOrEqualTo(0);
    }

    @Test
    void getTaskById() {
        // Create a new task first
        Task task = new Task(null, "Task by ID", "Testing Get by ID", false, new Date(), new Date());
        ResponseEntity<Task> postResponse = restTemplate.postForEntity(baseUrl, task, Task.class);
        Task createdTask = postResponse.getBody();

        // Get the created task by ID
        ResponseEntity<Task> getResponse = restTemplate.getForEntity(baseUrl + "/" + createdTask.getId(), Task.class);

        assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        Task retrievedTask = getResponse.getBody();
        assertThat(retrievedTask).isNotNull();
        assertThat(retrievedTask.getId()).isEqualTo(createdTask.getId());
        assertThat(retrievedTask.getTitle()).isEqualTo("Task by ID");
    }

    @Test
    void updateTask() {
        // Create a new task first
        Task task = new Task(null, "Update Task", "Testing Task Update", false, new Date(), new Date());
        ResponseEntity<Task> postResponse = restTemplate.postForEntity(baseUrl, task, Task.class);
        Task createdTask = postResponse.getBody();

        createdTask.setTitle("Updated Task");
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Task> entity = new HttpEntity<>(createdTask, headers);

        ResponseEntity<Task> updateResponse = restTemplate.exchange(
                baseUrl + "/" + createdTask.getId(), HttpMethod.PUT, entity, Task.class);

        assertThat(updateResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        Task updatedTask = updateResponse.getBody();
        assertThat(updatedTask.getTitle()).isEqualTo("Updated Task");
    }
}
