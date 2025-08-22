package org.example.environement.entity.enums;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;


public enum TravelMode {
    //Stockage en String dans la bdd
    @Enumerated(EnumType.STRING)
    WALKING, BIKE, CAR, BUS, TRAIN, PLANE
}
