package com.example.demo.service;

import com.example.demo.dto.UserInfo;
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

    public UserServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    PersonDao personDao;

    public List<String> getFilteredUsers() {
        return personRepo.getFilteredUsers();
    }

    public List<Person> getPersons(String dateBirth) {
        return personDao.findPersonsByNameLikeOrBirthDate(dateBirth);
    }

    public List<UserInfo> getUserInfo(Integer dptId) {
        return personDao.getUserInfo(dptId);
    }
}

