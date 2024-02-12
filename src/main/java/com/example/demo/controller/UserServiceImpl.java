package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.repo.PersonDao;
import com.example.demo.repo.PersonRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl {

    private PersonRepo personRepo;

    PersonDao personDao;

    public List<String> getFilteredUsers() {
        return personRepo.getFilteredUsers();
    }

    public List<Person> getPersons() {
        return personDao.findPersonsByNameLikeOrBirthDate();
    }
}

