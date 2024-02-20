package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

//@Data
@Entity
@Table(schema = "public", name = "person")
public class Person {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private Date birthDate;

    @ManyToOne
    @JoinColumn(name = "dpt_id", referencedColumnName = "id_dpt")
    private Dpt department;

    @Column(name = "age")
    private Integer age;

    public Person(Integer id, String firstName, String lastName, Date birthDate, Dpt department, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.department = department;
        this.age = age;
    }

    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Dpt getDepartment() {
        return department;
    }

    public void setDepartment(Dpt department) {
        this.department = department;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
