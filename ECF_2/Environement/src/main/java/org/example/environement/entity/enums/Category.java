package org.example.environement.entity.enums;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public enum Category {
    //Stockage en String dans la bdd
    @Enumerated(EnumType.STRING)
    BIRD, MAMMAL, INSECT, PLANT, OTHER
}
