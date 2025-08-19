package com.example.exercice2.controller;


import com.example.exercice2.dto.RealisateurResponseDto;
import com.example.exercice2.service.RealisateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/catalogue/realisateur")
public class RealisateurController {

    private final RealisateurService realisateurService;

    public RealisateurController(RealisateurService realisateurService) {
        this.realisateurService = realisateurService;
    }

    public ResponseEntity<List<RealisateurResponseDto>> getAllRealisateurs() {
        return ResponseEntity.ok(realisateurService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<RealisateurResponseDto> getOne(@PathVariable int id) {
        return ResponseEntity.ok(realisateurService.getId(id));
    }

}
