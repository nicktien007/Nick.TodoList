package com.nick.todolist.web;

import com.nick.todolist.Service.TaskService;
import com.nick.todolist.ViewModel.TaskVM;
import com.nick.todolist.domain.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @GetMapping("/")
    public String index(@PageableDefault(
            size = 5,
            sort = {"createDate"},
            direction = Sort.Direction.DESC) Pageable pageable,
                        Model model) {
        //Page<Task> tasks = service.findAllByPage(PageRequest.of(page,size, Sort.Direction.DESC,"id"));
        Page<TaskVM> tasks = service.findAllByPage(pageable);
        model.addAttribute("page", tasks);
        return "tasks";
    }

    @GetMapping("/tasks/{id}")
    public String detail(@PathVariable Long id, Model model) {

        Task task = service.getTaskById(id);
        model.addAttribute("task", task);

        return "detail";
    }

    @GetMapping("tasks/addTask")
    public String addTask(Model model){
        model.addAttribute("task", new Task());
        return "addTask";
    }

    @PostMapping("/addTask")
    public String addTask(Task task){
        service.saveTask(task);

        return "redirect:/";
    }

    @GetMapping("/tasks/edit/{id}")
    public String editTask(@PathVariable Long id ,Model model){
        Task task = service.getTaskById(id);
        model.addAttribute("task",task);

        return "addTask";
    }

    @GetMapping("/tasks/delete/{id}")
    public String delTask(@PathVariable Long id, @RequestParam int page){
        service.deleteTaskById(id);
        return "redirect:/"+"?page="+page;
    }
}
