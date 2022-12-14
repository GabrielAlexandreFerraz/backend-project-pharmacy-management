package com.api.projectpharmacy.controllers;

import com.api.projectpharmacy.dto.FarmaciaDto;
import com.api.projectpharmacy.models.FarmaciaModel;
import com.api.projectpharmacy.services.FarmaciaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farmacia")
public class FarmaciaController {
    final FarmaciaService farmaciaService;

    public FarmaciaController(FarmaciaService farmaciaService) {
        this.farmaciaService = farmaciaService;
    }
    @PostMapping
    public ResponseEntity<Object> saveFarmacia(@RequestBody @Valid FarmaciaDto farmaciaDto){
        var farmaciaModel = new FarmaciaModel();
        BeanUtils.copyProperties(farmaciaDto, farmaciaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(farmaciaService.save(farmaciaModel));
    }
    @GetMapping
    public ResponseEntity<List<FarmaciaModel>> listarTodasFarmacias(){
        return ResponseEntity.status(HttpStatus.OK).body(farmaciaService.findAll());
    }



}
