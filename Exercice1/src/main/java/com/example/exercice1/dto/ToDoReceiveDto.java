package com.example.exercice1.dto;


import com.example.exercice1.entity.ToDo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class ToDoReceiveDto {

    private String title;
    private String description;
    private String date;
    private Boolean isValidate;

    public ToDo dtoToEntity(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return ToDo.builder()
                .title(title)
                .description(description)
                .date(LocalDateTime.parse(date, formatter))
                .isValidate(isValidate)
                .build();


    }

}
