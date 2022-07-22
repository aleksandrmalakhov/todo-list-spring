package com.aleksandmalakhov.spring.todolistspring.repository;

import com.aleksandmalakhov.spring.todolistspring.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}