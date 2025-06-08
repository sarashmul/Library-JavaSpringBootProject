package com.example.SpringFirstProject.controllers;

import com.example.SpringFirstProject.entities.User;
import com.example.SpringFirstProject.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/getUser/{id}")
    public User getUserById(@PathVariable int id){
        return userService.findById(id);
    }

    @GetMapping("/")
    public List<User> getUsers(){
        return userService.findAll();
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id){
        return userService.deleteUser(id);
    }

    @GetMapping("/findByName/{name}")
    public List<User> findByName(@PathVariable String name){
        return userService.findByName(name);
    }


    @GetMapping("/findByEmail/{email}")
    public List<User> findByEmail(@PathVariable String email){
        return userService.selectUserByEmail(email);
    }

    @GetMapping("/findByAddress/{address}")
    public List<User> findByAddress(@PathVariable String address){
        return userService.selectUserByAddress(address);
    }

//    @GetMapping("/findByAddressAndSort/{address}/{sort}")
//    public List<User> findByAddressAndSort(@PathVariable String address,@PathVariable String sort){
//        return userService.selectUserByAddressAndSort(address, Sort.by(sort));
//    }
}
