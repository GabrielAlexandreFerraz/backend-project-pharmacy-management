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
import java.util.Optional;
import java.util.UUID;

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
    @GetMapping("/{id}")
    public ResponseEntity<Object> getPorId(@PathVariable(value = "id") UUID id){
        Optional<FarmaciaModel> farmaciaModelOptional = farmaciaService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(farmaciaModelOptional.get());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarPorId(@PathVariable(value = "id") UUID id){
        Optional<FarmaciaModel> farmaciaModelOptional = farmaciaService.findById(id);
        farmaciaService.delete(farmaciaModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("deletado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePorId(@PathVariable(value = "id") UUID id,
                                              @RequestBody @Valid FarmaciaDto farmaciaDto){
        Optional<FarmaciaModel> farmaciaModelOptional = farmaciaService.findById(id);
        var farmaciaModel = farmaciaModelOptional.get();
        farmaciaModel.setRazaoSocial(farmaciaDto.getRazaoSocial());
        farmaciaModel.setCnpj(farmaciaDto.getCnpj());
        farmaciaModel.setNomeFantasia(farmaciaDto.getNomeFantasia());
        farmaciaModel.setEmail(farmaciaDto.getEmail());
        farmaciaModel.setTelefoneFixo(farmaciaDto.getTelefoneFixo());
        farmaciaModel.setCelular(farmaciaDto.getCelular());
        farmaciaModel.setCep(farmaciaDto.getCep());
        farmaciaModel.setEndereco(farmaciaDto.getEndereco());
        farmaciaModel.setNumero(farmaciaDto.getNumero());
        farmaciaModel.setBairro(farmaciaDto.getBairro());
        farmaciaModel.setCidade(farmaciaDto.getCidade());
        farmaciaModel.setEstado(farmaciaDto.getEstado());
        farmaciaModel.setLatitude(farmaciaDto.getLatitude());
        farmaciaModel.setLongitute(farmaciaDto.getLongitute());
        return ResponseEntity.status(HttpStatus.OK).body(farmaciaService.save(farmaciaModel));

    }



}
