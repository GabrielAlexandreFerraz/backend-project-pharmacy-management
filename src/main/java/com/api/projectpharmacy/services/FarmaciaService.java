package com.api.projectpharmacy.services;

import com.api.projectpharmacy.repositories.FarmaciaRepository;
import org.springframework.stereotype.Service;

@Service
public class FarmaciaService {
    final
    FarmaciaRepository farmaciaRepository;

    public FarmaciaService(FarmaciaRepository farmaciaRepository) {
        this.farmaciaRepository = farmaciaRepository;
    }
}
