package com.example.company.controllers;

import com.example.company.model.DB;
import com.example.company.model.Profession;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/profession")
public class ProfessionController {
    private DB db;

    public ProfessionController() {
        this.db = new DB();
    }

    @GetMapping
    public List<Profession> findAll(){
        return db.findAll();
    }

    @PostMapping
    private void save(@RequestParam String name,@RequestParam String note){
        Profession profession = new Profession(name, note);
        db.save(profession);
    }
    @PostMapping ("/save")
    private void save (@RequestBody Profession profession){
        db.save(profession);
    }

    @PostMapping ("/remove")
    private void remove (@RequestParam Integer id){
        db.remove(id);
    }
//    @PostMapping ("/remove")
//    private void remove (@RequestBody Profession profession){
//        db.remove(profession);
//    }

    @PostMapping ("/update")
    private void update (@RequestParam Integer id, @RequestParam String name, @RequestParam String note){
        db.update(id, name, note);
    }
}
