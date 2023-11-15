package com.example.demo;

import com.example.demo.models.User;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class regService {

    private final UserRepository userRepository;

    @Autowired
    public regService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByValue(String value) {
        return userRepository.findByEmail(value);
    }

}