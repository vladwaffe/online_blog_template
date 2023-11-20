package com.example.demo.controllers;

import com.example.demo.Author;
import com.example.demo.HibernateUtils;
import com.example.demo.models.User;
import com.example.demo.models.login_user;
import com.example.demo.repo.UserRepository;

import com.example.demo.repo.loginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Objects;

@Controller
public class RegController {
    @Autowired
    private UserRepository usersRepository;
    @Autowired
    private loginRepository logRepository;

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
        Author author = new Author();
        if(Objects.equals(user.getPassword(), passwd)) {
            login_user log_user = new login_user(user.getEmail());
            logRepository.save(log_user);
            author.setEmail(user.getEmail());
            author.setPersonal_id(user.getId());
            Author.getAuthor_list().add(author);
            String str = "redirect:/" + author.getEmail() + "/blog";
            return str;
        }
        else{
            return "redirect:/";
        }
    }
    @GetMapping ("/logOut")
    public String logOut(Model model){

        ;
        return "redirect:/";
    }
}
