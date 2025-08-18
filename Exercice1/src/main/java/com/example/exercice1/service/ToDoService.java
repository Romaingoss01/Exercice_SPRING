package com.example.exercice1.service;

import com.example.exercice1.dto.ToDoReceiveDto;
import com.example.exercice1.dto.ToDoResponseDto;
import com.example.exercice1.entity.ToDo;
import com.example.exercice1.repository.ToDoRepository;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public ToDoResponseDto create (ToDoReceiveDto toDoReceiveDto) {
        return toDoRepository.save(toDoReceiveDto.dtoToEntity()).entityToDto();
    }

    public ToDoResponseDto get(int id){
        return toDoRepository.findById(id).orElseThrow().entityToDto();
    }

    public ToDoResponseDto getAll(){
        return toDoRepository.findAll().stream().map(ToDo::entityToDto).toList();
    }

    public void delete(int id){
        toDoRepository.deleteById(id);
    }

    public ToDoResponseDto update(int id, ToDoReceiveDto toDoReceiveDto) {
        ToDo toDoRecupere = toDoRepository.findById(id).orElseThrow();
        ToDo toDOEnvoie = toDoReceiveDto.dtoToEntity();
        toDoRecupere.setDescription(toDOEnvoie.getDescription());
        toDoRecupere.setDate(toDOEnvoie.getDate());
        toDoRecupere.setTitle(toDOEnvoie.getTitle());
        return toDoRepository.save(toDoRecupere).entityToDto();
    }



}
