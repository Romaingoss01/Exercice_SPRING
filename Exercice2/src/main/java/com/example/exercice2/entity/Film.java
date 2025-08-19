package com.example.exercice2.entity;


import com.example.exercice2.dto.FilmResponseDto;
import com.example.exercice2.dto.RealisateurResponseDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private LocalDate dateDeSortie;
    private String description;
    private int duree;
    private String genre;

    @ManyToOne(optional = false) // un film doit avoir un réalisateur
    @JoinColumn(name = "realisateur_id") // clé étrangère
    private Realisateur realisateur;

    // Receive => Entity => Response
    public FilmResponseDto entityToDto(){
        return FilmResponseDto.builder()
                .id(id)
                .nom(nom)
                .dateDeSortie(dateDeSortie)
                .description(description)
                .duree(duree)
                .genre(genre)
                .realisateur(RealisateurResponseDto.builder()
                        .id(realisateur.getId())
                        .nom(realisateur.getNom())
                        .prenom(realisateur.getPrenom())
                        .dateNaissance(realisateur.getDateNaissance())
                        .nationalite(realisateur.getNationalite())
                        .build()
                )
                .build();
    }
}
