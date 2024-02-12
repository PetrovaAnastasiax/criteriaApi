package com.example.demo.controller;

import com.example.demo.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private UserServiceImpl userService;

    @GetMapping("/filtered")
    public List<String> getFilteredUsers() {
        return userService.getFilteredUsers();
    }

    @GetMapping("/crit")
    public List<Person> getPersons() {
        return userService.getPersons();
    }
}
