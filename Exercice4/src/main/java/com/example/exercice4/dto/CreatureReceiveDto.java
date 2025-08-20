package com.example.exercice4.dto;


import com.example.exercice4.entity.Creature;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreatureReceiveDto {

    private int id;
    @Size(min = 4, max = 20)
    private String name;
    @Size(min = 1, max = 200)
    private int age;
    @Size(min = 1, max = 200)
    private double weight;
    private boolean dangerous;
    private Creature.TypeCreature type;

    public Creature dtoToEntity() {
        return Creature.builder()
                .id(id)
                .name(name)
                .age(age)
                .weight(weight)
                .dangerous(dangerous)
                .type(type)
                .build();
    }

}