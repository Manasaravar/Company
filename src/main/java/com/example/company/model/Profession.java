package com.example.company.model;

import lombok.Data;

@Data
public class Profession {
    private Integer id;
    private String name;
    private String note;

    public Profession(Integer id, String name, String note) {
        this.id = id;
        this.name = name;
        this.note = note;
    }

    public Profession(String name, String note) {
        this.name = name;
        this.note = note;
    }

    public Profession() {
    }
}

