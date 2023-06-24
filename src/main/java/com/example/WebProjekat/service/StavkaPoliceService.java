package com.example.WebProjekat.service;

import com.example.WebProjekat.model.StavkaPolice;
import com.example.WebProjekat.repository.StavkaPoliceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StavkaPoliceService {
    @Autowired
    StavkaPoliceRepository stavkaPoliceRepository;

    public void deleteById(long id){
        stavkaPoliceRepository.deleteById(id);
    }

    public Optional<StavkaPolice> findById(long id) {
        return stavkaPoliceRepository.findById(id);
    }

    public void delete(StavkaPolice stavkaPolice) {
        stavkaPoliceRepository.delete(stavkaPolice);
    }

    public StavkaPolice save(StavkaPolice stavkaPolice) {
        return stavkaPoliceRepository.save(stavkaPolice);
    }
}
