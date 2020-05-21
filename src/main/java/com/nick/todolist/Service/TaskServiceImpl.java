package com.nick.todolist.Service;

import com.nick.todolist.ViewModel.TaskVM;
import com.nick.todolist.domain.Task;
import com.nick.todolist.domain.TaskRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepo repo;

    public static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    @Override
    public List<Task> findAllTasks() {
        return repo.findAll();
    }

    @Override
    public Page<TaskVM> findAllByPage(Pageable pageable) {
        Page<Task> taskPage = repo.findAll(pageable);

        return taskPage.map(this::getTaskVm);
    }

    private TaskVM getTaskVm(Task x) {
        return TaskVM.builder()
                .id(x.getId())
                .title(x.getTitle())
                .description(x.getDescription().length() > 15
                        ? x.getDescription().substring(0,15) + "..."
                        : x.getDescription())
                .createDate(DATE_FMT.format(x.getCreateDate()))
                .deadLine(DATE_FMT.format(x.getDeadLine()))
                .done(x.getDone())
                .isWarning(x.getDeadLine().isBefore(LocalDateTime.now()) && !x.getDone())
                .build();
    }

    @Override
    public Task getTaskById(Long id) {
        Optional<Task> optionalTask = repo.findById(id);
        return optionalTask.orElse(new Task());
    }

    @Override
    public Task saveTask(Task task) {
        return repo.save(task);
    }

    @Override
    public Task updateTask(Task task) {
        return repo.save(task);
    }

    @Override
    public void deleteTaskById(Long id) {
        repo.deleteById(id);
    }
}
