package com.example.SpringFirstProject.controllers;

import com.example.SpringFirstProject.entities.User;
import com.example.SpringFirstProject.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/general")
@RequiredArgsConstructor
public class GeneralController {

    private final UserService userService;

    @GetMapping("/")
    public String welcome(){
        return "Hello World";
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        return "Hello "+name;
    }

    @PostMapping("/hellopost")
    public String helloPost(@RequestBody String name){
        return "Hello post "+name;
    }

    @GetMapping("/get")
    public List<User> getUser(){
        return userService.findAll();
    }

}
