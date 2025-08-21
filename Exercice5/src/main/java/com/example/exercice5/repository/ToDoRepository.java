package com.example.exercice5.repository;

import com.example.exercice5.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<Todo, Integer> {
}
