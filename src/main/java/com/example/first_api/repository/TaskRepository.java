package com.example.first_api.repository;

// interface que estende de uma config feita já para o spring data jpa

import com.example.first_api.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> { //vai gerenciar Task e o tipo de sua chave primária é Long.

}
