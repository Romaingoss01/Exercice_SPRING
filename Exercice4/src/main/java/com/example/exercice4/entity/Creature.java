package com.example.exercice4.entity;

import com.example.exercice4.dto.CreatureResponseDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class Creature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;
    private double weight;
    private boolean dangerous;

    @Enumerated(EnumType.STRING)
    private TypeCreature type;

    public enum TypeCreature {
        DRAGON, ELF, ORC, HUMAN, DWARF;
    }

    public CreatureResponseDto entityToDto() {
        return CreatureResponseDto.builder()
                .id(id)
                .name(name)
                .age(age)
                .weight(weight)
                .dangerous(dangerous)
                .type(type)
                .build();
    }

}
