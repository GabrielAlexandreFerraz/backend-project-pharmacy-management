package com.api.projectpharmacy.controllers;

import com.api.projectpharmacy.dto.FarmaciaDto;
import com.api.projectpharmacy.models.FarmaciaModel;
import com.api.projectpharmacy.respostaPadrao.RespostaPadrao;
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
    public ResponseEntity<RespostaPadrao> saveFarmacia(@RequestBody @Valid FarmaciaDto farmaciaDto){
        var farmaciaModel = new FarmaciaModel();
        BeanUtils.copyProperties(farmaciaDto, farmaciaModel);
        farmaciaModel = farmaciaService.save(farmaciaModel);
        RespostaPadrao respostaPadrao = new RespostaPadrao(HttpStatus.CREATED, "farmacia salva com sucesso", farmaciaModel);
        return new ResponseEntity<>(respostaPadrao, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<RespostaPadrao> getPorId(@PathVariable(value = "id") UUID id){
        Optional<FarmaciaModel> farmaciaModelOptional = farmaciaService.findById(id);
        FarmaciaModel farmaciaModel = farmaciaModelOptional.get();
        RespostaPadrao respostaPadrao = new RespostaPadrao(HttpStatus.OK, "Farmacia Encontrada", farmaciaModel);
        return ResponseEntity.ok(respostaPadrao);
    }
    @GetMapping
    public ResponseEntity<RespostaPadrao<List<FarmaciaModel>>> listarTodasFarmacias(){
        RespostaPadrao<List<FarmaciaModel>> ListaFarmacias = new RespostaPadrao<>();
        ListaFarmacias.setStatus(HttpStatus.OK);
        ListaFarmacias.setMensagem("Lista de Login");
        ListaFarmacias.setDados(farmaciaService.findAll());
        return ResponseEntity.status(HttpStatus.OK).body(ListaFarmacias);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarPorId(@PathVariable(value = "id") UUID id){
        Optional<FarmaciaModel> farmaciaModelOptional = farmaciaService.findById(id);
        farmaciaService.delete(farmaciaModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Farmacia deletada com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<RespostaPadrao> updatePorId(@PathVariable(value = "id") UUID id,
                                              @RequestBody @Valid FarmaciaDto farmaciaDto){
        Optional<FarmaciaModel> farmaciaModelOptional = farmaciaService.findById(id);
        FarmaciaModel farmaciaModel = farmaciaModelOptional.get();
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
        farmaciaModel = farmaciaService.save(farmaciaModel);
        RespostaPadrao respostaPadrao = new RespostaPadrao<>(HttpStatus.OK,"Farmacia Alterada com sucesso",farmaciaModel);
        return ResponseEntity.ok(respostaPadrao);

    }



}
