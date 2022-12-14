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
public class FarmaciaDto {
    @NotBlank
    private String razaoSocial;

    @NotBlank
    private String cnpj;

    @NotBlank
    private String email;

    @NotBlank
    private String telefoneFixo;

    @NotBlank
    private String celular;

    @NotBlank
    private String cep;

    @NotBlank
    private String endereco;

    @NotBlank
    private String numero;

    @NotBlank
    private String bairro;

    @NotBlank
    private String cidade;

    @NotBlank
    private String estado;

    @NotBlank
    private String latitude;

    @NotBlank
    private String longitute;
}
