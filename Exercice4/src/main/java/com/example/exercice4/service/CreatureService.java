package com.example.exercice4.service;

import com.example.exercice4.dto.CreatureReceiveDto;
import com.example.exercice4.dto.CreatureResponseDto;
import com.example.exercice4.entity.Creature;
import com.example.exercice4.repository.CreatureRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreatureService {

    private final CreatureRepository creatureRepository;

    public CreatureService(CreatureRepository creatureRepository) {
        this.creatureRepository = creatureRepository;
    }

    public CreatureResponseDto create(CreatureReceiveDto creatureReceiveDto) {
        return creatureRepository.save(creatureReceiveDto.dtoToEntity()).entityToDto();
    }

    public CreatureResponseDto findById(int id) {
        return creatureRepository.findById(id).orElseThrow().entityToDto();
    }

    public List<CreatureResponseDto> getAll() {
        return creatureRepository.findAll().stream().map(Creature::entityToDto).toList();
    }

    public  void deleteById(int id) {
        creatureRepository.deleteById(id);
    }

    public CreatureResponseDto update(int id, CreatureReceiveDto creatureReceiveDto) {
        Creature creatureTrouvé = creatureRepository.findById(id).orElseThrow();
        Creature creatureMaj = creatureReceiveDto.dtoToEntity();
        creatureMaj.setName(creatureReceiveDto.getName());
        creatureMaj.setAge(creatureReceiveDto.getAge());
        creatureMaj.setDangerous(creatureReceiveDto.isDangerous());
        creatureMaj.setWeight(creatureReceiveDto.getWeight());
        creatureMaj.setType(creatureReceiveDto.getType());
        return creatureRepository.save(creatureMaj).entityToDto();
    }

    public Page<Creature> getPage(Pageable pageable) { return creatureRepository.findAll(pageable); }


}
