package com.api.projectpharmacy.controllers;

import com.api.projectpharmacy.dto.MedicamentoDto;
import com.api.projectpharmacy.models.MedicamentoModel;
import com.api.projectpharmacy.respostaPadrao.RespostaPadrao;
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
    public ResponseEntity<RespostaPadrao> saveMedicamento(@RequestBody @Valid MedicamentoDto medicamentoDto){
        var medicamentoModel = new MedicamentoModel();
        BeanUtils.copyProperties(medicamentoDto, medicamentoModel);
        medicamentoModel = medicamentoService.save(medicamentoModel);
        RespostaPadrao respostaPadrao = new RespostaPadrao(HttpStatus.CREATED,"Medicamento salvo com sucesso", medicamentoModel);
        return new ResponseEntity<>(respostaPadrao, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespostaPadrao> getPorId(@PathVariable(value = "id") UUID id){
        Optional<MedicamentoModel> medicamentoModelOptional = medicamentoService.findById(id);
        MedicamentoModel medicamentoModel = medicamentoModelOptional.get();
        RespostaPadrao respostaPadrao = new RespostaPadrao(HttpStatus.OK, "Medicamento Encontrado", medicamentoModel);
        return ResponseEntity.ok(respostaPadrao);
    }

    @GetMapping
    public ResponseEntity<RespostaPadrao<List<MedicamentoModel>>> listarTodosMedicamentos(){
        RespostaPadrao<List<MedicamentoModel>> ListaMedicamentos = new RespostaPadrao<>();
        ListaMedicamentos.setStatus(HttpStatus.OK);
        ListaMedicamentos.setMensagem("Lista de Login");
        ListaMedicamentos.setDados(medicamentoService.findAll());
        return ResponseEntity.status(HttpStatus.OK).body(ListaMedicamentos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarPorId(@PathVariable(value = "id") UUID id){
        Optional<MedicamentoModel> medicamentoModelOptional = medicamentoService.findById(id);
        medicamentoService.delete(medicamentoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Medicamento deletado com sucesso");
    }
    @PutMapping("/{id}")
    public ResponseEntity<RespostaPadrao> updatePorId(@PathVariable(value = "id") UUID id,
                                              @RequestBody @Valid MedicamentoDto medicamentoDto){
        Optional<MedicamentoModel> medicamentoModelOptional = medicamentoService.findById(id);
        MedicamentoModel medicamentoModel = medicamentoModelOptional.get();
        medicamentoModel.setNomeMedicamentos(medicamentoDto.getNomeMedicamentos());
        medicamentoModel.setPrecoMedicamentos(medicamentoDto.getPrecoMedicamentos());
        medicamentoModel.setDosagemMedicamentos(medicamentoDto.getDosagemMedicamentos());
        medicamentoModel.setTipoMedicamentos(medicamentoDto.getTipoMedicamentos());
        medicamentoModel.setLaboratorioMedicamentos(medicamentoDto.getLaboratorioMedicamentos());
        medicamentoModel.setMedicamentosControlados(medicamentoDto.getMedicamentosControlados());
        medicamentoModel = medicamentoService.save(medicamentoModel);
        RespostaPadrao respostaPadrao = new RespostaPadrao<>(HttpStatus.OK,"Medicamento Alterado com sucesso",medicamentoModel);
        return ResponseEntity.ok(respostaPadrao);

    }


}
