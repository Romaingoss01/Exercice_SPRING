package com.example.exercice1.entity;


import com.example.exercice1.dto.ToDoResponseDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private LocalDateTime date;
    private Boolean isValidate;

    public ToDoResponseDto entityToDto() {
        return ToDoResponseDto.builder()
                .id(id)
                .title(title)
                .description(description)
                .isValidate(isValidate).build();
    }
}
