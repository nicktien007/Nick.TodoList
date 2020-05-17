package com.nick.todolist.Service;

import com.nick.todolist.domain.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TaskService {

    List<Task> findAllTasks();

    Page<Task> findAllByPage(Pageable pageable);

    Task getTaskById(Long id);

    Task saveTask(Task task);

    Task updateTask(Task task);

    void deleteTaskById(Long id);
 }
