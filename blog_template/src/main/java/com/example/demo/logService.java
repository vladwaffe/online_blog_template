package com.example.demo;

import com.example.demo.models.login_user;
import com.example.demo.repo.loginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class logService {

    private final loginRepository loginRepository;

    @Autowired
    public logService(loginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public login_user findByValue(String value) {
        return loginRepository.findByEmail(value);
    }

}