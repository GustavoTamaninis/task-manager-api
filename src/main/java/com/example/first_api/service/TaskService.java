package com.example.first_api.service;

import com.example.first_api.entity.Task;
import com.example.first_api.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    
    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id){
        return taskRepository.findById(id); // tá retornando um optional, oq garante que o obj não venha nulo
    }

    public Task createTask(Task task){
        taskRepository.save(task);
        return task;
    }

    public Task updateTask(Long id, Task task){
        return taskRepository.findById(id)
                .map(existingTask -> {
                    existingTask.setTitle(task.getTitle());
                    existingTask.setDescription(task.getDescription());
                    return taskRepository.save(existingTask);
                 })
                .orElseThrow(() -> new RuntimeException("Task não encontrada."));
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
}
