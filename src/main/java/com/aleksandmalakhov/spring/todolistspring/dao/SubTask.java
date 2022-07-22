package com.aleksandmalakhov.spring.todolistspring.dao;

import com.aleksandmalakhov.spring.todolistspring.entity.Task;
import lombok.Data;
import lombok.NonNull;

import java.text.SimpleDateFormat;

@Data
public class SubTask {
    private int id;
    private String heading;
    private String description;
    private String date;

    public SubTask(@NonNull Task task) {
        this.id = task.getId();
        this.heading = task.getHeading();
        this.description = task.getDescription();
        this.date = new SimpleDateFormat("dd.MM.yyyy").format(task.getDate());
    }
}