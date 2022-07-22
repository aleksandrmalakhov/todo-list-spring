package com.aleksandmalakhov.spring.todolistspring.service;

import com.aleksandmalakhov.spring.todolistspring.dao.SubTask;
import com.aleksandmalakhov.spring.todolistspring.entity.Task;
import com.aleksandmalakhov.spring.todolistspring.repository.TaskRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService<Task, SubTask> {
    private final TaskRepository repository;

    @Override
    public boolean save(@NonNull Task task) {
        if (task.getHeading().isBlank() || task.getDescription().isBlank() || task.getDate() == null) {
            return false;
        } else {
            repository.save(task);
            return true;
        }
    }

    @Override
    public Optional<SubTask> findById(int id) {
        Optional<Task> task = repository.findById(id);
        return task.map(SubTask::new);
    }

    @Override
    public List<SubTask> findAll() {
        List<Task> list = repository.findAll();
        return !list.isEmpty() ?
                list.stream()
                        .map(SubTask::new)
                        .collect(Collectors.toList()) :
                List.of();
    }

    @Override
    public boolean deleteById(int id) {
        if (this.findById(id).isPresent()) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteAll() {
        if (this.findAll().isEmpty()) {
            return false;
        } else {
            repository.deleteAll();
            return true;
        }
    }
}