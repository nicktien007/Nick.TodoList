package com.nick.todolist.web;

import com.nick.todolist.Service.TaskService;
import com.nick.todolist.domain.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @GetMapping("/")
    public String index(Model model) {

        List<Task> tasks = service.findAllTasks();
        model.addAttribute("tasks", tasks);

        return "tasks";
    }

    @GetMapping("/tasks/{id}")
    public String detail(@PathVariable Long id, Model model) {

        Task task = service.getTaskById(id);
        model.addAttribute("task", task);

        return "detail";
    }

    @GetMapping("tasks/addTask")
    public String addTask(){
        return "addTask";
    }

    @PostMapping("/addTask")
    public String addTask(Task task){
        service.saveTask(task);

        return "redirect:/";
    }
}
