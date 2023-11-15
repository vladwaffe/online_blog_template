package com.example.demo.controllers;

import com.example.demo.Author;
import com.example.demo.HibernateUtils;
import com.example.demo.models.User;
import com.example.demo.repo.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegController {
    @Autowired
    private UserRepository usersRepository;


    @GetMapping("/singIn")
    public String sing_in(Model model){
        return "sing-in";
    }
    @PostMapping("/singIn")
    public String singIn_reg(@RequestParam String email, @RequestParam String passwd, Model model){
        User user = new User(email, passwd);
        usersRepository.save(user);
        return "redirect:/blog";
    }
    @GetMapping("/logIn")
    public String log_in(Model model){
        return "log-in";
    }

    @PostMapping("/logIn")
    public String logIn_reg(@RequestParam String email, @RequestParam String passwd, Model model){
        HibernateUtils.getSession().beginTransaction();
        //User user = HibernateUtils.getSession().byNaturalId(User.class).using("email", email).load();
        User user = usersRepository.findByEmail(email);
        Author author = new Author(user.getId());
        return "redirect:/blog";
    }
    @GetMapping ("/logOut")
    public String logOut(Model model){
        return "redirect:/";
    }
}
