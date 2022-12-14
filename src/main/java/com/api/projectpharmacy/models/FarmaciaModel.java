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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_FARMACIA")
public class FarmaciaModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 60)
    private String razaoSocial;

    @Column(nullable = false, unique = true, length = 60)
    private String cnpj;

    @Column(nullable = false, length = 120)
    private String email;

    @Column(nullable = false, length = 120)
    private String telefoneFixo;

    @Column(nullable = false, length = 120)
    private String celular;

    @Column(nullable = false, length = 120)
    private String cep;

    @Column(nullable = false, length = 120)
    private String endereco;

    @Column(nullable = false, length = 120)
    private String numero;

    @Column(nullable = false, length = 120)
    private String bairro;

    @Column(nullable = false, length = 120)
    private String cidade;

    @Column(nullable = false, length = 120)
    private String estado;

    @Column(nullable = false, length = 300)
    private String latitude;

    @Column(nullable = false, length = 300)
    private String longitute;

    //talvez colocar
    //@Column(nullable = false)
    //private LocalDateTime registrationDate;

}
