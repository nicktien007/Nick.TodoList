package com.nick.todolist.Service;

import com.nick.todolist.ViewModel.TaskVM;
import com.nick.todolist.domain.Task;
import com.nick.todolist.domain.TaskRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepo repo;

    @Override
    public List<Task> findAllTasks() {
        return repo.findAll();
    }

    @Override
    public Page<TaskVM> findAllByPage(Pageable pageable) {
        Page<Task> taskPage = repo.findAll(pageable);
        Page<TaskVM> taskVMpage = taskPage.map(x -> TaskVM.builder()
                .id(x.getId())
                .title(x.getTitle())
                .description(x.getDescription())
                .createDate(x.getCreateDate())
                .deadLine(x.getDeadLine())
                .done(x.getDone())
                .build());

        return taskVMpage;
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
