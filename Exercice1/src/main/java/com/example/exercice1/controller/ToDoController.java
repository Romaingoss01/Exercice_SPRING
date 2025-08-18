package com.example.exercice1.controller;


import com.example.exercice1.dto.ToDoReceiveDto;
import com.example.exercice1.dto.ToDoResponseDto;
import com.example.exercice1.service.ToDoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ToDo")
public class ToDoController {

    private ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ToDoResponseDto>> getAll() {
        return ResponseEntity.ok.(toDoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDoResponseDto> getOne(@PathVariable int id) {
        return ResponseEntity.ok(toDoService.get(id));
    }

    @PostMapping("/new")
    public ResponseEntity<ToDoResponseDto> create(@RequestBody ToDoReceiveDto toDoReceiveDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(toDoService.create(toDoReceiveDto));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        toDoService.delete(id);
        return ResponseEntity.ok(String.format("Delete Todo with id %d", id));
    }
}
