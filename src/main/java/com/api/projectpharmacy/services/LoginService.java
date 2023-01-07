package com.api.projectpharmacy.services;

import com.api.projectpharmacy.models.LoginModel;
import com.api.projectpharmacy.repositories.LoginRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class LoginService {
    final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public LoginModel save(LoginModel loginModel) {return loginRepository.save(loginModel);}

    public List<LoginModel> findAll() {
        return loginRepository.findAll();
    }

    public Optional<LoginModel> findById(UUID id) {
        return loginRepository.findById(id);
    }
    public void delete(LoginModel loginModel) {
        loginRepository.delete(loginModel);
    }


}
