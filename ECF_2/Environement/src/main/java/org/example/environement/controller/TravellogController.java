package org.example.environement.controller;

import org.example.environement.dto.travellogs.TravellogDtoReceive;
import org.example.environement.dto.travellogs.TravellogDtoResponse;
import org.example.environement.dto.travellogs.TravellogDtoStat;
import org.example.environement.service.TravellogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/travel-logs")
public class TravellogController {

    private final TravellogService travellogsService;

    public TravellogController(TravellogService travellogsService) {
        this.travellogsService = travellogsService;
    }

    //http://localhost:8080/api/travel-logs
    @GetMapping
    public ResponseEntity<TravellogDtoResponse> createTravelLog(@RequestBody TravellogDtoReceive travellogDtoReceive, @RequestParam long observationId) {
        TravellogDtoResponse created = travellogsService.create(travellogDtoReceive, observationId);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    //http://localhost:8080/api/travel-logs/stats/{id}
    @GetMapping("/stats/{id}")
    public ResponseEntity<TravellogDtoStat> getStatFromObseration (@PathVariable long id){
        return ResponseEntity.ok(travellogsService.getStat(id));
    }


    //http://localhost:8080/api/travel-logs/user/{name}
    @GetMapping("/user/{name}")
    public ResponseEntity<Map<String,TravellogDtoStat>> getTravelStatForUserOnLAstMonth (@PathVariable String name){
        return ResponseEntity.ok(travellogsService.getStatForUserLastMonth(name));
    }
}
