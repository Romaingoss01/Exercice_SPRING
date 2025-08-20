package com.example.exercice4.config;

import com.example.exercice4.entity.Creature;
import com.example.exercice4.repository.CreatureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.stream.IntStream;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(CreatureRepository creatureRepository) {
        return args -> {
            //Generer 50 creatures
            IntStream.rangeClosed(1,50).forEach(i -> {
                Creature creature = new Creature();
                creature.setName("Creature -"+i);
                creature.setAge(20+i);
                creature.setWeight(15.5+i);
                creature.setType(Creature.TypeCreature.DRAGON);
                creature.setDangerous(true);
                creatureRepository.save(creature);
            });
        };
    }
}
