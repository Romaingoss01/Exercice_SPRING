package com.example.exercice5.service;

import com.example.exercice5.dto.RegisterRequestDto;
import com.example.exercice5.entity.Todo;
import com.example.exercice5.exception.NotFoundException;
import com.example.exercice5.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;
    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public Todo enregistrerToDo(RegisterRequestDto registerRequestDto) throws NotFoundException {
        Optional<Todo> ToDoOptional = toDoRepository.findById(registerRequestDto.getId());

        if(ToDoOptional.isEmpty()){

            //créer un todo avec juste un titre si pas existant
            Todo leToDo = Todo.builder().build().setTitre(registerRequestDto.getTitre());
            return toDoRepository.save(leToDo);
        }

        throw new NotFoundException();
    }
}
