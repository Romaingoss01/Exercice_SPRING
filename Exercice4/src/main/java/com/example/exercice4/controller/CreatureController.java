package com.example.exercice4.controller;

import com.example.exercice4.dto.CreatureReceiveDto;
import com.example.exercice4.dto.CreatureResponseDto;
import com.example.exercice4.entity.Creature;
import com.example.exercice4.service.CreatureService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/creature")
public class CreatureController {

    private CreatureService creatureService;

    public CreatureController(CreatureService creatureService) {
        this.creatureService = creatureService;
    }

    @GetMapping
    public ResponseEntity<List<CreatureResponseDto>> getAllCreatures() {
        return ResponseEntity.ok(creatureService.getAll());
    }

    @PostMapping()
    public ResponseEntity<CreatureResponseDto> createCreature(@Valid @RequestBody CreatureReceiveDto creatureReceiveDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(creatureService.create(creatureReceiveDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreatureResponseDto> getCreatureById(@PathVariable int id) {
        return ResponseEntity.ok(creatureService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreatureResponseDto> update(@PathVariable int id, @RequestBody CreatureReceiveDto creatureReceiveDto) {
        return ResponseEntity.ok(creatureService.update(id, creatureReceiveDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCreature(@PathVariable int id) {
        creatureService.deleteById(id);
        return ResponseEntity.ok(String.format("Delete user with id %d", id));
    }

    @GetMapping("/paged")
    public Page<Creature> getPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size){
        return creatureService.getPage(PageRequest.of(page, size));
    }









}
