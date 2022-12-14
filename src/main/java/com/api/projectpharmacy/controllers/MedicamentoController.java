package com.api.projectpharmacy.controllers;


import com.api.projectpharmacy.dto.FarmaciaDto;
import com.api.projectpharmacy.dto.MedicamentoDto;
import com.api.projectpharmacy.models.FarmaciaModel;
import com.api.projectpharmacy.models.MedicamentoModel;
import com.api.projectpharmacy.services.MedicamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicamento")
public class MedicamentoController {
    final MedicamentoService medicamentoService;

    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }
    @PostMapping
    public ResponseEntity<Object> saveMedicamento(@RequestBody @Valid MedicamentoDto medicamentoDto){
        var medicamentoModel = new MedicamentoModel();
        BeanUtils.copyProperties(medicamentoDto, medicamentoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicamentoService.save(medicamentoModel));
    }

    @GetMapping
    public ResponseEntity<List<MedicamentoModel>> listarTodosMedicamentos(){
        return ResponseEntity.status(HttpStatus.OK).body(medicamentoService.findAll());
    }




}
