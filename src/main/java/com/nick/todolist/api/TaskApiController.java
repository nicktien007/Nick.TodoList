package com.nick.todolist.api;

import com.nick.todolist.Service.TaskService;
import com.nick.todolist.ViewModel.TaskVM;
import com.nick.todolist.domain.Task;
import com.nick.todolist.utils.CopyUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TaskApiController {

    private final TaskService service;

    @GetMapping("/tasks")
    public ResponseEntity<?> getAllTasks(){
        List<Task> allTasks = service.findAllTasks();
        return new ResponseEntity<>(allTasks, HttpStatus.OK);
    }

    @GetMapping("/tasksByPage")
    public ResponseEntity<?> getAllTasksByPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size){
        Page<TaskVM> taskPage = service.findAllByPage(PageRequest.of(page, size, Sort.Direction.DESC, "id"));
        return new ResponseEntity<>(taskPage,HttpStatus.OK);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<?> getTaskById( @PathVariable Long id){
        Task task = service.getTaskById(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PostMapping("/tasks")
    public ResponseEntity<?> saveTask(@RequestBody Task task){
        Task saveTask = service.saveTask(task);
        return new ResponseEntity<>(saveTask, HttpStatus.CREATED);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<?> saveTask(@PathVariable Long id ,@RequestBody Task sourceTask){
        Task oldTask = service.getTaskById(id);
        CopyUtils.copyProperties(sourceTask,oldTask);
        Task updateTask = service.updateTask(oldTask);
        return new ResponseEntity<>(updateTask, HttpStatus.OK);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id){
        service.deleteTaskById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
