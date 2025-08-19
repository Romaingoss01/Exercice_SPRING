package com.example.exercice2.repository;

import com.example.exercice2.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FilmRepository extends JpaRepository<Film, Integer> {
}
