package com.api.projectpharmacy.services;

import com.api.projectpharmacy.models.FarmaciaModel;
import com.api.projectpharmacy.models.MedicamentoModel;
import com.api.projectpharmacy.repositories.MedicamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MedicamentoService {

    final
    MedicamentoRepository medicamentoRepository;

    public MedicamentoService(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }
    public MedicamentoModel save(MedicamentoModel medicamentoModel) {
        return medicamentoRepository.save(medicamentoModel);
    }
    public List<MedicamentoModel> findAll() {
        return medicamentoRepository.findAll();
    }


    public Optional<MedicamentoModel> findById(UUID id) {
        return medicamentoRepository.findById(id);
    }
    public void delete(MedicamentoModel medicamentoModel) {
        medicamentoRepository.delete(medicamentoModel);
    }


}
