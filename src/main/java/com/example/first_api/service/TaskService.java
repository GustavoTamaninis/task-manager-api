package com.example.first_api.service;

import com.example.first_api.entity.Task;
import com.example.first_api.repository.TaskRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {
    @Autowired
    private TaskRespository taskRespository;

    public List<Task> getAllTasks(){
        return taskRespository.findAll();
    }

    public Optional<Task> getTaskById(Long id){
        return taskRespository.findById(id); // tá retornando um opcional, oq garante que o obj não venha nulo
    }

    public Task createTask(Task task){
        taskRespository.save(task);
        return task;
    }

    public Task updateTask(Long id, Task task){
        task.setId(id);
        taskRespository.save(task);
        return task;
    }

    public void deleteTask(Long id){
        taskRespository.deleteById(id);
    }
}
