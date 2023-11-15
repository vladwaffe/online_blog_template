package com.example.demo.controllers;

import com.example.demo.models.Post;
import com.example.demo.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private PostRepository postRepository;


    @GetMapping("/blog")
    public String blogMain(Model model){
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);

        return "blog-main";
    }
    @GetMapping("/{email}/blog")
    public String blogMainId(@PathVariable(value = "email") String email, Model model){
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);

        return "redirect:/blog";
    }

    @GetMapping("/blog/add")
    public String blogAdd(Model model){
        return "new-post";
    }

    @PostMapping("/blog/add")
    public String addPost(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text,  Model model){
        Post post = new Post(title, anons, full_text);
        postRepository.save(post);
        return "redirect:/blog";
    }
    @PostMapping("/{id}/blog/add")
    public String addPost(@PathVariable(value = "id") long id,
                          @RequestParam String title, @RequestParam String anons, @RequestParam String full_text,  Model model){
        Post post = new Post(title, anons, full_text);
        postRepository.save(post);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model){
        if(postRepository.existsById(id)){
            Optional<Post> post = postRepository.findById(id);
            ArrayList<Post> res = new ArrayList<>();
            post.ifPresent(res::add);
            model.addAttribute("post", res);
            return "post_page";
        }
        else {
            return "redirect:/blog";
        }

    }

    @GetMapping("/blog/{id}/edit")
    public String blogDetailsEdit(@PathVariable(value = "id") long id, Model model){
        if(postRepository.existsById(id)){
            Optional<Post> post = postRepository.findById(id);
            ArrayList<Post> res = new ArrayList<>();
            post.ifPresent(res::add);
            model.addAttribute("post", res);
            return "post_page_edit";
        }
        else {
            return "redirect:/blog";
        }
    }

    @PostMapping("/blog/{id}/edit")
    public String editPost(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text, @PathVariable(value = "id") long id,  Model model){
        Post post = postRepository.findById(id).orElseThrow();
        post.setTitle(title);
        post.setAnons(anons);
        post.setFull_text(full_text);
        postRepository.save(post);
        return "redirect:/blog/{id}";
    }

    @PostMapping("/blog/{id}/remove")
    public String removePost(@PathVariable(value = "id") long id,  Model model){
        postRepository.deleteById(id);
        return "redirect:/blog";
    }



}
