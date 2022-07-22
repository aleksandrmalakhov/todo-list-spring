package com.aleksandmalakhov.spring.todolistspring.controller;

import com.aleksandmalakhov.spring.todolistspring.dao.SubTask;
import com.aleksandmalakhov.spring.todolistspring.entity.Task;
import com.aleksandmalakhov.spring.todolistspring.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@CrossOrigin
public class MyRESTController {
    private final TaskService<Task, SubTask> taskService;

    @PostMapping("/tasks")
    public ResponseEntity<Task> addNewTask(@RequestBody Task task) {
        return taskService.save(task) ?
                ResponseEntity.ok(task) :
                ResponseEntity.of(Optional.empty());
    }

    @PutMapping("/tasks")
    public ResponseEntity<Task> updateTask(@RequestBody Task task) {
        return taskService.save(task) ?
                ResponseEntity.ok(task) :
                ResponseEntity.of(Optional.empty());
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<SubTask>> showAllTasks() {
        List<?> subTasks = taskService.findAll();
        return subTasks.isEmpty() ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(subTasks.stream()
                        .map(s -> (SubTask) s)
                        .collect(Collectors.toList()));
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<SubTask> getTask(@PathVariable int id) {
        Optional<?> subTask = taskService.findById(id);
        return subTask.map(o -> ResponseEntity.ok((SubTask) o))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable int id) {
        return taskService.deleteById(id) ?
                ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();

    }

    @DeleteMapping("/tasks")
    public ResponseEntity<String> deleteAllTasks() {
        return taskService.deleteAll() ?
                ResponseEntity.ok("Success!") :
                ResponseEntity.unprocessableEntity().body("No data found");
    }
}