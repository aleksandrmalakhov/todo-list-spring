package com.aleksandmalakhov.spring.todolistspring.service;

import java.util.List;
import java.util.Optional;

public interface TaskService<T, DAO> {
    boolean save(T entity);

    Optional<DAO> findById(int id);

    List<DAO> findAll();

    boolean deleteById(int id);

    boolean deleteAll();
}