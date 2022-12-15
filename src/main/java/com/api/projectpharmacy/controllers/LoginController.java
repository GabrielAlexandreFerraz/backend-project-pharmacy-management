package com.api.projectpharmacy.controllers;

import com.api.projectpharmacy.dto.LoginDto;
import com.api.projectpharmacy.models.LoginModel;
import com.api.projectpharmacy.services.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/login")
public class LoginController {

    final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<Object> saveLogin(@RequestBody @Valid LoginDto loginDto){
        var loginModel = new LoginModel();
        BeanUtils.copyProperties(loginDto, loginModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(loginService.save(loginModel));
    }

    @GetMapping
    public ResponseEntity<List<LoginModel>> listarTodosLogin(){
        return ResponseEntity.status(HttpStatus.OK).body(loginService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPorId(@PathVariable(value = "id") UUID id){
        Optional<LoginModel> loginModelOptional = loginService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(loginModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarPorId(@PathVariable(value = "id") UUID id){
        Optional<LoginModel> loginModelOptional = loginService.findById(id);
        loginService.delete(loginModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("deletado com sucesso");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePorId(@PathVariable(value = "id") UUID id,
                                              @RequestBody @Valid LoginDto loginDto) {
        Optional<LoginModel> loginModelOptional = loginService.findById(id);
        var loginModel = loginModelOptional.get();
        loginModel.setEmail(loginDto.getEmail());
        loginModel.setSenha(loginDto.getSenha());
        return ResponseEntity.status(HttpStatus.OK).body(loginService.save(loginModel));
    }

}
