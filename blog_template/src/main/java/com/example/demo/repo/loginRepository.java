package com.example.demo.repo;

import com.example.demo.models.login_user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface loginRepository extends JpaRepository<login_user, Long> {
    login_user findByEmail(String value);
}
