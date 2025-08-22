package org.example.environement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.environement.dto.specie.SpecieDtoResponse;
import org.example.environement.dto.travellogs.TravellogDtoResponse;
import org.example.environement.entity.enums.TravelMode;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Travellog {
    //Renommage de propriétés avec Underscore pour la BDD
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "observation_id")
    private Observation observation;
    @Column(name = "distance_km")
    private Double distanceKm;
    //Stockage en String dans la bdd
    @Enumerated(EnumType.STRING)
    private TravelMode mode;
    @Column(name = "estimated_co2_kg")
    private Double estimatedCo2Kg;


    public TravellogDtoResponse entityToDto() {
        return TravellogDtoResponse.builder()
                .id(id)
                .distanceKm(distanceKm)
                .mode(mode.name())
                .estimatedCo2Kg(estimatedCo2Kg)
                .build();

    }

    public void calculateCO2(){
        double facteurEmission;
        switch (mode) {
            case WALKING, BIKE -> facteurEmission = 0.0;
            case CAR -> facteurEmission = 0.22;
            case BUS -> facteurEmission = 0.11;
            case TRAIN -> facteurEmission = 0.03;
            case PLANE -> facteurEmission = 0.259;
            default -> facteurEmission = 0.0;
        }
        this.estimatedCo2Kg = this.distanceKm * facteurEmission;

    }
}
