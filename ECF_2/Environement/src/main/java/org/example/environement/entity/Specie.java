package org.example.environement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.environement.dto.specie.SpecieDtoResponse;
import org.example.environement.entity.enums.Category;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Specie {
    //Renommage de propriétés avec Underscore pour la BDD
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, name = "common_name")
    private String commonName;
    @Column(nullable = false, name = "scientific_name")
    private String scientificName;
    @Column(nullable = false)
    //Stockage en STRING dans la BDD
    @Enumerated(EnumType.STRING)
    private Category category;

    public SpecieDtoResponse entityToDto (){
        return SpecieDtoResponse.builder()
                .id(this.getId())
                .category(this.getCategory().toString())
                .scientificName(this.getScientificName())
                .commonName(this.getCommonName())
                .build();
    }

}
