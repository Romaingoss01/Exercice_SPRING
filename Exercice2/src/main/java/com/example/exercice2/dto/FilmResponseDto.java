package com.example.exercice2.dto;

import com.example.exercice2.entity.Film;
import com.example.exercice2.entity.Realisateur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FilmResponseDto {

    private int id;
    private String nom;
    private LocalDate dateDeSortie;
    private String description;
    private int duree;
    private String genre;
    private RealisateurResponseDto realisateur;



}
