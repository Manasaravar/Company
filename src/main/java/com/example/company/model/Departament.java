package com.example.company.model;

public class Departament {
    private Integer id;
    private String nameOfDep;
    private String group;

    public Departament(String nameOfDep, String group) {
        this.nameOfDep = nameOfDep;
        this.group = group;
    }

    public Departament() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameOfDep() {
        return nameOfDep;
    }

    public void setNameOfDep(String nameOfDep) {
        this.nameOfDep = nameOfDep;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
