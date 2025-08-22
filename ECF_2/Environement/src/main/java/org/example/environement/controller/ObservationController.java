package org.example.environement.controller;

import org.example.environement.dto.observation.ObservationDtoReceive;
import org.example.environement.dto.observation.ObservationDtoResponse;
import org.example.environement.service.ObservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/observations")
public class ObservationController {

    private final ObservationService observationService;

    public ObservationController(ObservationService observationService) {
        this.observationService = observationService;
    }

    //http://localhost:8080/api/observations
    @GetMapping
    public ResponseEntity<List<ObservationDtoResponse>> getAll(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize) {
        return ResponseEntity.ok(observationService.get(pageSize, pageNumber));
    }

    //http://localhost:8080/api/observations
    @PostMapping
    public ResponseEntity<ObservationDtoResponse> create(@RequestBody ObservationDtoReceive observationDtoReceive) {
        return ResponseEntity.ok(observationService.create(observationDtoReceive));
    }

    //http://localhost:8080/api/observations/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ObservationDtoResponse> getById(@PathVariable long id) {
        return ResponseEntity.ok(observationService.get(id));
    }

    //http://localhost:8080/api/observations/by-location
    @GetMapping("/by-location")
    public ResponseEntity<List<ObservationDtoResponse>> getObservationByLocation(@RequestParam String location) {
        return ResponseEntity.ok(observationService.getByLocation(location));
    }

    //http://localhost:8080/api/observations/by-species/{speciesId}
    @GetMapping("/by-species/{speciesId}")
    public ResponseEntity<List<ObservationDtoResponse>> getObservationBySpecies(@PathVariable long speciesId) {
        return ResponseEntity.ok(observationService.getBySpecie(speciesId));
    }
}
