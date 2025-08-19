package com.example.exercice2.controller;


import com.example.exercice2.dto.FilmResponseDto;
import com.example.exercice2.dto.RealisateurResponseDto;
import com.example.exercice2.service.FilmService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/catalogue/film")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    public ResponseEntity<List<FilmResponseDto>> getAllRealisateurs() {
        return ResponseEntity.ok(filmService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmResponseDto> getById(@PathVariable int id) {
        return ResponseEntity.ok(filmService.getId(id));
    }


}
