package com.example.exercice2.service;


import com.example.exercice2.dto.RealisateurReceiveDto;
import com.example.exercice2.dto.RealisateurResponseDto;
import com.example.exercice2.entity.Realisateur;
import com.example.exercice2.repository.RealisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealisateurService {

    private final RealisateurRepository realisateurRepository;

    public RealisateurService(RealisateurRepository realisateurRepository) {
        this.realisateurRepository = realisateurRepository;
    }

    public RealisateurResponseDto create (RealisateurReceiveDto realisateurReceiveDto) {
        return realisateurRepository.save(realisateurReceiveDto.DtoToEntity()).entityToDto();
    }

    public List<RealisateurResponseDto> getAll() {
        return realisateurRepository.findAll().stream()
                .map(Realisateur::entityToDto)
                .toList();
    }

    public RealisateurResponseDto getId(int id){
        return realisateurRepository.findById(id).orElseThrow().entityToDto();
    }

    public void delete(int id){
        RealisateurResponseDto realisateurResponseDto = getId(id);
        realisateurRepository.deleteById(id);
    }

    public RealisateurResponseDto update(int id, RealisateurReceiveDto realisateurReceiveDto){
        Realisateur realUno =  realisateurRepository.findById(id).orElseThrow();
        Realisateur realChange = realisateurReceiveDto.DtoToEntity();
        realUno.setNom(realChange.getNom());
        realUno.setPrenom(realChange.getPrenom());
        realUno.setDateNaissance(realChange.getDateNaissance());
        realUno.setNationalite(realChange.getNationalite());
        return realisateurRepository.save(realUno).entityToDto();
    }





}
