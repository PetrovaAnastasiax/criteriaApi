package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "DPT")
public class Dpt {

    @Id
    @Column(name = "id_dpt")
    private Integer idDpt;

    @Column(name = "name_dpt")
    private String nameDpt;

    @Column(name = "avg_salary")
    private Integer avgSalary;

    public Dpt() {
    }

    public Integer getIdDpt() {
        return idDpt;
    }

    public void setIdDpt(Integer idDpt) {
        this.idDpt = idDpt;
    }

    public String getNameDpt() {
        return nameDpt;
    }

    public void setNameDpt(String nameDpt) {
        this.nameDpt = nameDpt;
    }

    public Integer getAvgSalary() {
        return avgSalary;
    }

    public void setAvgSalary(Integer avgSalary) {
        this.avgSalary = avgSalary;
    }
}
