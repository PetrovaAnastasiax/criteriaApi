package com.example.demo.controller;

import com.example.demo.dto.UserInfo;
import com.example.demo.model.Person;
import com.example.demo.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    private UserServiceImpl userService;

    @GetMapping("/filtered")
    public List<String> getFilteredUsers() {
        return userService.getFilteredUsers();
    }

    @GetMapping("/crit")
    public List<Person> getPersons(@Param("dateBirth") String dateBirth) {
        return userService.getPersons(dateBirth);
    }

    @GetMapping("/dptname")
    public List<UserInfo> getUserDpt(@RequestParam("dptId") Integer dptId){
        return userService.getUserInfo(dptId);
    }
}
