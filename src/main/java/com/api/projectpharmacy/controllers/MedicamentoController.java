package com.api.projectpharmacy.controllers;


import com.api.projectpharmacy.dto.MedicamentoDto;
import com.api.projectpharmacy.models.MedicamentoModel;
import com.api.projectpharmacy.services.MedicamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPorId(@PathVariable(value = "id")UUID id){
        Optional<MedicamentoModel> medicamentoModelOptional = medicamentoService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(medicamentoModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarPorId(@PathVariable(value = "id") UUID id){
        Optional<MedicamentoModel> medicamentoModelOptional = medicamentoService.findById(id);
        medicamentoService.delete(medicamentoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("deletado com sucesso");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePorId(@PathVariable(value = "id") UUID id,
                                              @RequestBody @Valid MedicamentoDto medicamentoDto){
        Optional<MedicamentoModel> medicamentoModelOptional = medicamentoService.findById(id);
        var medicamentoModel = medicamentoModelOptional.get();
        medicamentoModel.setNomeMedicamentos(medicamentoDto.getNomeMedicamentos());
        medicamentoModel.setPrecoMedicamentos(medicamentoDto.getPrecoMedicamentos());
        medicamentoModel.setDosagemMedicamentos(medicamentoDto.getDosagemMedicamentos());
        medicamentoModel.setTipoMedicamentos(medicamentoDto.getTipoMedicamentos());
        medicamentoModel.setLaboratorioMedicamentos(medicamentoDto.getLaboratorioMedicamentos());
        medicamentoModel.setMedicamentosControlados(medicamentoDto.getMedicamentosControlados());
        return ResponseEntity.status(HttpStatus.OK).body(medicamentoService.save(medicamentoModel));

    }


}
