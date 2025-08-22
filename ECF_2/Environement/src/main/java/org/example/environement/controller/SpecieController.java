package org.example.environement.controller;

import org.example.environement.dto.specie.SpecieDtoReceive;
import org.example.environement.dto.specie.SpecieDtoResponse;
import org.example.environement.service.SpecieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/species")
public class SpecieController {

    private final SpecieService specieService;

    public SpecieController(SpecieService specieService) {
        this.specieService = specieService;
    }

    //http://localhost:8080/api/species
    @GetMapping
    public ResponseEntity<List<SpecieDtoResponse>> getAll(
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "0") int pageNumber) {
        return ResponseEntity.ok(specieService.get(pageSize, pageNumber));
    }

    //http://localhost:8080/api/species/{id}
    @GetMapping("/{id}")
    public ResponseEntity<SpecieDtoResponse> getById(@PathVariable long id) {
        return ResponseEntity.ok(specieService.get(id));
    }

    //http://localhost:8080/api/species
    @PostMapping
    public ResponseEntity<SpecieDtoResponse> create(@RequestBody SpecieDtoReceive specieDtoReceive) {
        return ResponseEntity.status(HttpStatus.CREATED).body(specieService.create(specieDtoReceive));
    }


}
