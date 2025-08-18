package com.example.exercice1.repository;

import com.example.exercice1.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo,Integer> {
}
