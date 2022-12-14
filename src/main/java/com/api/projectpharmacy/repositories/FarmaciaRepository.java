package com.api.projectpharmacy.repositories;

import com.api.projectpharmacy.models.FarmaciaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FarmaciaRepository extends JpaRepository<FarmaciaModel, UUID> {
}
