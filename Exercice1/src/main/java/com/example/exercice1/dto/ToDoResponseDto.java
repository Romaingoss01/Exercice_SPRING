package com.example.exercice1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class ToDoResponseDto {

    private int id;
    private String title;
    private String description;
    private Boolean isValidate;
}
