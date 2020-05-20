package com.nick.todolist.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(nullable = false)
    private LocalDateTime deadLine = LocalDateTime.now().plusDays(1);

    private LocalDateTime createDate = LocalDateTime.now();

    @Column(nullable = false)
    private Boolean done = false;
}
