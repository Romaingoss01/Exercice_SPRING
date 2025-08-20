package com.example.exercice4.repository;

import com.example.exercice4.entity.Creature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreatureRepository extends JpaRepository<Creature, Integer> {
}
