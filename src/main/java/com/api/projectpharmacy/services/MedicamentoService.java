package com.api.projectpharmacy.services;

import com.api.projectpharmacy.repositories.MedicamentoRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicamentoService {

    final
    MedicamentoRepository medicamentoRepository;

    public MedicamentoService(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }
}
