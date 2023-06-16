package com.example.WebProjekat.service;

import com.example.WebProjekat.model.Knjiga;
import com.example.WebProjekat.repository.KnjigaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KnjigaService {
    @Autowired
    private KnjigaRepository knjigaRepository;

    public List<Knjiga> findAll() {
        return knjigaRepository.findAll();
    }

    public List<Knjiga> findAllByNaslov(String string) {
        return knjigaRepository.findAllByNaslov(string);
    }

    public List<Knjiga> findByNaslov(String string) {
        return knjigaRepository.findByNaslov(string);
    }

    public List<Knjiga> findByZanr_Naziv(String string) {
        return knjigaRepository.findByZanr_Naziv(string);
    }

    public List<Knjiga> findByNaslovIgnoreCaseContaining(String naslov) {
        if(naslov == null){
            return knjigaRepository.findAll();
        }
        return knjigaRepository.findByNaslovIgnoreCaseContaining(naslov);
    }

    public Optional<Knjiga> findById(long id) {
        return knjigaRepository.findById(id);
    }
}
