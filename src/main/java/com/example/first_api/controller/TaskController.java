package com.example.first_api.controller;

import com.example.first_api.entity.Task;
import com.example.first_api.service.TaskService;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks") // definição de qual rota será escutada.
public class TaskController {
//    @Autowired
    private TaskService taskService; // por ser uma classe de serviço o spring já a implementou.

        public TaskController(TaskService taskService){
            // Ao inicializar esse construtor, essa classe já vai implementar taskService:
            // É uma alternativa mais recomendada que o @Autowired.
            this.taskService = taskService;
        }

    @GetMapping // É uma response. Neste caso, retorna uma lista.
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping //
    public ResponseEntity<Task> createTask(@RequestBody Task task){ // o objeto JSON é convertido para o tipo Task.
        taskService.createTask(task);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @GetMapping("/{id}") // após o mapeamento de "/tasks", ou seja, o usuário faz uma requisição a "/tasks/7" e recebe isso:
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){ // é uma parte da URL e não o corpo de um parâmetro no corpo da requisição.
        Optional<Task> task = taskService.getTaskById(id);
        if(task.isPresent())
            return new ResponseEntity<>(task.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(new Task(), HttpStatus.NOT_FOUND);
    }

    @PutMapping("{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task){
        taskService.updateTask(id, task);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
