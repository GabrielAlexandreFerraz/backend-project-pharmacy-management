package com.api.projectpharmacy.repositories;

import com.api.projectpharmacy.models.MedicamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MedicamentoRepository extends JpaRepository<MedicamentoModel, UUID> {
}
