package com.example.exercice4.dto;

import com.example.exercice4.entity.Creature;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreatureResponseDto {

    private int id;
    private String name;
    private int age;
    private double weight;
    private boolean dangerous;
    private Creature.TypeCreature type;
}
