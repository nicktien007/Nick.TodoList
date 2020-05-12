package com.nick.todolist.web;

import com.nick.todolist.Service.TaskService;
import com.nick.todolist.domain.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @GetMapping("/")
    public String index() {
        return "tasks";
    }

    @GetMapping("/tasks/{id}")
    public String detail(@PathVariable Long id, Model model) {

        Task task = service.getTaskById(id);
        model.addAttribute("task", task);

        return "detail";
    }
}
