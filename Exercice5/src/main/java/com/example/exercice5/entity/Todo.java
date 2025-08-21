package com.example.exercice5.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Todo {

    private String id;
    private String description;
    private String titre;
    private String date;
    private boolean isValidate;

}
