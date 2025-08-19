package com.example.exercice2.service;

import com.example.exercice2.dto.FilmReceiveDto;
import com.example.exercice2.dto.FilmResponseDto;
import com.example.exercice2.dto.RealisateurReceiveDto;
import com.example.exercice2.dto.RealisateurResponseDto;
import com.example.exercice2.entity.Film;
import com.example.exercice2.entity.Realisateur;
import com.example.exercice2.repository.FilmRepository;
import com.example.exercice2.repository.RealisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    private final FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public FilmResponseDto create (FilmReceiveDto filmReceiveDto) {
        return filmRepository.save(filmReceiveDto.dtoToEntity()).entityToDto();
    }


    public FilmResponseDto getId(int id) {
        return filmRepository.findById(id).orElseThrow().entityToDto();
    }

    public void deleteById(int id) {
        filmRepository.deleteById(id);
    }

    public List<FilmResponseDto> getAll() {
        return filmRepository.findAll().stream()
                .map(Film::entityToDto)
                .toList();
    }


    public FilmResponseDto update(int id, FilmReceiveDto filmReceiveDto){
        Film filmUno =  filmRepository.findById(id).orElseThrow();
        Film filmChange = filmReceiveDto.dtoToEntity();
        filmUno.setNom(filmChange.getNom());
        filmUno.setDescription(filmChange.getDescription());
        filmUno.setGenre(filmChange.getGenre());
        filmUno.setRealisateur(filmChange.getRealisateur());
        filmUno.setDateDeSortie(filmChange.getDateDeSortie());
        filmUno.setDuree(filmChange.getDuree());
        return filmRepository.save(filmUno).entityToDto();
    }







}
