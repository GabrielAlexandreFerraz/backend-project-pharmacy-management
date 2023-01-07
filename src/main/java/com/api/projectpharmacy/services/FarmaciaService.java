package com.api.projectpharmacy.services;

import com.api.projectpharmacy.models.FarmaciaModel;
import com.api.projectpharmacy.repositories.FarmaciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    public Optional<FarmaciaModel> findById(UUID id) {
        return farmaciaRepository.findById(id);
    }

    public void delete(FarmaciaModel farmaciaModel) {
        farmaciaRepository.delete(farmaciaModel);
    }
}
