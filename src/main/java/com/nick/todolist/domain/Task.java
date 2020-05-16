package com.nick.todolist.domain;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.swing.text.html.Option;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

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
    private LocalDateTime deadLine;

    private LocalDateTime createDate = LocalDateTime.now();

    @Column(nullable = false)
    private Boolean done = false;
}
