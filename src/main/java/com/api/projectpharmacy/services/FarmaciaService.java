package com.api.projectpharmacy.services;

import com.api.projectpharmacy.models.FarmaciaModel;
import com.api.projectpharmacy.repositories.FarmaciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmaciaService {
    final
    FarmaciaRepository farmaciaRepository;

    public FarmaciaService(FarmaciaRepository farmaciaRepository) {
        this.farmaciaRepository = farmaciaRepository;
    }

    public FarmaciaModel save(FarmaciaModel farmaciaModel) {
        return farmaciaRepository.save(farmaciaModel);
    }

    public List<FarmaciaModel> findAll() {
        return farmaciaRepository.findAll();
    }
}
