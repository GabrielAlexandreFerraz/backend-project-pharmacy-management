package com.api.projectpharmacy.feign;

import com.api.projectpharmacy.dto.LoginDto;
import com.api.projectpharmacy.models.LoginModel;
import com.api.projectpharmacy.respostaPadrao.RespostaPadrao;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "login-feign",url = "http://localhost:8080/login")
public interface LoginFeignClient {
    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<RespostaPadrao> saveLogin(@RequestBody @Valid LoginDto loginDto);

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<RespostaPadrao> getPorId(@PathVariable("id") UUID id);

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ResponseEntity<RespostaPadrao<List<LoginModel>>> listarTodosLogin();

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<RespostaPadrao> deletarPorId(@PathVariable("id") UUID id);

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<RespostaPadrao> updatePorId(@PathVariable(value = "id") UUID id,
                                                      @RequestBody @Valid LoginDto loginDto);

}