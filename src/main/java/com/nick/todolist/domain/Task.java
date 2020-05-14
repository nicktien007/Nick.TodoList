package com.nick.todolist.domain;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;
import lombok.Value;

import javax.persistence.*;
import javax.swing.text.html.Option;
import java.util.Date;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String description;

    private Date deadLine;

    private Date createDate;

    private Boolean done;
}
