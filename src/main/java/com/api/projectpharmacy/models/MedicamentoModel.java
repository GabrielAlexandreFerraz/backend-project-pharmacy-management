package com.api.projectpharmacy.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_MEDICAMENTO")
public class MedicamentoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 120)
    private String nomeMedicamentos;

    @Column(nullable = false, length = 120)
    private String precoMedicamentos;

    @Column(nullable = false, length = 120)
    private String dosagemMedicamentos;

    @Column(nullable = false, length = 120)
    private String tipoMedicamentos;

    @Column(nullable = false, length = 120)
    private String laboratorioMedicamentos;

    @Column(nullable = false, length = 120)
    private String medicamentosControlados;

}
