package com.aleksandmalakhov.spring.todolistspring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "heading")
    private String heading;

    @Column(name = "description")
    private String description;

    @DateTimeFormat
    @Column(name = "date")
    private Date date;

    public Task(String heading, String description, Date date) {
        this.heading = heading;
        this.description = description;
        this.date = date;
    }
}