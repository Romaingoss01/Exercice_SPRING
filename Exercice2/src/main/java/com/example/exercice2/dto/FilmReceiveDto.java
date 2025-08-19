package com.example.exercice2.dto;

import com.example.exercice2.entity.Film;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class FilmReceiveDto {

    private String nom;
    private LocalDate dateDeSortie;
    private String description;
    private int duree;
    private String genre;
    private int Idrealisateur;

    public Film dtoToEntity() {
        return Film.builder()
                .nom(nom)
                .dateDeSortie(dateDeSortie)
                .duree(duree)
                .description(description)
                .genre(genre)
                .id(Idrealisateur)
                .build();
    }


}
