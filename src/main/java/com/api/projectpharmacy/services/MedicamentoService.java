package com.api.projectpharmacy.services;

import com.api.projectpharmacy.models.FarmaciaModel;
import com.api.projectpharmacy.models.MedicamentoModel;
import com.api.projectpharmacy.repositories.MedicamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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


}
