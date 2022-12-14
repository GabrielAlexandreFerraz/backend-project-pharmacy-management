package com.api.projectpharmacy.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicamentoDto {
    @NotBlank
    private String nomeMedicamentos;

    @NotBlank
    private String precoMedicamentos;

    @NotBlank
    private String dosagemMedicamentos;

    @NotBlank
    private String tipoMedicamentos;

    @NotBlank
    private String laboratorioMedicamentos;

    @NotBlank
    private String medicamentosControlados;
}
