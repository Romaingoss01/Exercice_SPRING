package com.example.exercice2.entity;


import com.example.exercice2.dto.RealisateurResponseDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class Realisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String nationalite;
    @OneToMany(mappedBy = "realisateur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Film> films = new ArrayList<>();


    // Receive => Entity => Response
    public RealisateurResponseDto entityToDto(){
        return RealisateurResponseDto.builder()
                .id(id)
                .nom(nom)
                .prenom(prenom)
                .dateNaissance(dateNaissance)
                .nationalite(nationalite)
                .build();
    }
}
