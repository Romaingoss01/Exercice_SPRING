package com.example.exercice2.dto;

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
public class RealisateurResponseDto {

    private int  id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String nationalite;


}
