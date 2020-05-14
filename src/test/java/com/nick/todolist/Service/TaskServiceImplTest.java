package com.nick.todolist.Service;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nick.todolist.domain.*;
import org.assertj.core.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskServiceImplTest {

    @Autowired
    private TaskRepo repo;

    @Autowired
    private TaskService service;

    private final Gson gson =  new GsonBuilder().setPrettyPrinting().create();

    @Test
    void saveTaskTest() {
        Task task = new Task();
        task.setTitle("task1");
        task.setDescription("desc1");
        task.setDeadLine(DateUtil.now());
        task.setCreateDate(DateUtil.now());
        task.setDone(false);

        repo.save(task);
    }

    @Test
    void findAllTasksTest() {
        List<Task> tasks = service.findAllTasks();

        System.out.println(gson.toJson(tasks));
    }

    @Test
    void getTaskByIdTest() {
        Task task = service.getTaskById(1L);
        System.out.println(gson.toJson(task));
    }

    @Test
    void updateTaskTest() {
        Task task = service.getTaskById(1L);
        task.setTitle("99999");
        Task updateData = service.updateTask(task);
        System.out.println(updateData);
    }

    @Test
    void deleteTaskByIdTest() {
        service.deleteTaskById(5L);
    }
}