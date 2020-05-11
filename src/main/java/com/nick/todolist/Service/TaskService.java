package com.nick.todolist.Service;

import com.nick.todolist.domain.Task;

import java.util.List;

public interface TaskService {

    List<Task> findAllTasks();

    Task getTaskById(Long id);

    Task saveTask(Task task);

    Task updateTask(Task task);

    void deleteTaskById(Long id);
 }
