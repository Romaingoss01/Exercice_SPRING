package com.example.exercice5.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RegisterResponseDto {

    private int id;
    private String description;
    private String titre;
    private String date;
    private boolean isValidate;
}
