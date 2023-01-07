package com.api.projectpharmacy.controllers;

import com.api.projectpharmacy.dto.LoginDto;
import com.api.projectpharmacy.models.LoginModel;
import com.api.projectpharmacy.respostaPadrao.RespostaPadrao;
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
    public ResponseEntity<RespostaPadrao> saveLogin(@RequestBody @Valid LoginDto loginDto){
        var loginModel = new LoginModel();
        BeanUtils.copyProperties(loginDto, loginModel);
        loginModel = loginService.save(loginModel);
        RespostaPadrao respostaPadrao = new RespostaPadrao(HttpStatus.CREATED,"login salvo com sucesso", loginModel);
        return new ResponseEntity<>(respostaPadrao, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<RespostaPadrao> getPorId(@PathVariable(value = "id") UUID id){
        Optional<LoginModel> loginModelOptional = loginService.findById(id);
        LoginModel loginModel = loginModelOptional.get();
        RespostaPadrao respostaPadrao = new RespostaPadrao(HttpStatus.OK, "Login Encontrado", loginModel);
        return ResponseEntity.ok(respostaPadrao);
    }

    @GetMapping
    public ResponseEntity<RespostaPadrao<List<LoginModel>>> listarTodosLogin(){
        RespostaPadrao<List<LoginModel>> ListaLogin = new RespostaPadrao<>();
        ListaLogin.setStatus(HttpStatus.OK);
        ListaLogin.setMensagem("Lista de Login");
        ListaLogin.setDados(loginService.findAll());
        return ResponseEntity.status(HttpStatus.OK).body(ListaLogin);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarPorId(@PathVariable(value = "id") UUID id){
        Optional<LoginModel> loginModelOptional = loginService.findById(id);
        loginService.delete(loginModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Login Deletado com Sucesso");
    }
    @PutMapping("/{id}")
    public ResponseEntity<RespostaPadrao> updatePorId(@PathVariable(value = "id") UUID id,
                                              @RequestBody @Valid LoginDto loginDto) {
        Optional<LoginModel> loginModelOptional = loginService.findById(id);
        LoginModel loginModel = loginModelOptional.get();
        loginModel.setEmail(loginDto.getEmail());
        loginModel.setSenha(loginDto.getSenha());
        loginModel = loginService.save(loginModel);
        RespostaPadrao respostaPadrao = new RespostaPadrao(HttpStatus.OK, "Login Alterado com sucesso", loginModel);
        return ResponseEntity.ok(respostaPadrao);
    }

}
