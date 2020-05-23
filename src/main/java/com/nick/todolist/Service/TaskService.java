package com.nick.todolist.Service;

import com.nick.todolist.ViewModel.TaskVM;
import com.nick.todolist.domain.Task;
import com.nick.todolist.enums.TaskListType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TaskService {

    List<Task> findAllTasks();

    Page<TaskVM> findAllByPage(Pageable pageable , TaskListType type);

    Page<TaskVM> findAllByPageAndDone(Pageable pageable, boolean done);

    Task getTaskById(Long id);

    Task saveTask(Task task);

    Task updateTask(Task task);

    void deleteTaskById(Long id);

    void deleteAllTask();

    void tagDone(Long id);

    void tagNotDone(Long id);

 }
